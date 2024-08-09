package main

import (
	"context"
	"errors"
	orderpb "github.com/qwertydi/order-service/pb"
	"github.com/qwertydi/order-service/server"
	"github.com/qwertydi/order-service/util"
	"github.com/rs/zerolog"
	"github.com/rs/zerolog/log"
	"go.mongodb.org/mongo-driver/mongo"
	"go.mongodb.org/mongo-driver/mongo/options"
	"golang.org/x/sync/errgroup"
	"google.golang.org/grpc"
	"google.golang.org/grpc/credentials/insecure"
	"google.golang.org/grpc/reflection"
	"net"
	"os"
	"os/signal"
	"syscall"
)

var interruptSignals = []os.Signal{
	os.Interrupt,
	syscall.SIGTERM,
	syscall.SIGINT,
}

func main() {
	config, err := util.LoadConfig(".")
	if err != nil {
		log.Fatal().Err(err).Msg("cannot load config")
	}

	if config.Environment == "development" {
		log.Logger = log.Output(zerolog.ConsoleWriter{Out: os.Stderr})
	}

	ctx, stop := signal.NotifyContext(context.Background(), interruptSignals...)
	defer stop()

	waitGroup, ctx := errgroup.WithContext(ctx)
	runGrpcServer(ctx, waitGroup, config)

	err = waitGroup.Wait()
	if err != nil {
		log.Fatal().Err(err).Msg("error from wait group")
	}
}

func runGrpcServer(
	ctx context.Context,
	waitGroup *errgroup.Group,
	config util.Config) {

	clientOptions := options.Client().ApplyURI(config.DBUrl)

	// Connect to MongoDB
	mongoClient, err := mongo.Connect(ctx, clientOptions)

	if err != nil {
		log.Fatal().Err(err).Msg("cannot create listener")

	}

	// Check the connection
	if err = mongoClient.Ping(ctx, nil); err != nil {
		log.Fatal().Err(err).Msg("cannot create listener")

	}

	log.Info().Msg("MongoClient connected")

	srv, err := server.NewServer(config, mongoClient)
	if err != nil {
		log.Fatal().Err(err).Msg("cannot create server")
	}

	gprcLogger := grpc.UnaryInterceptor(server.GrpcLogger)
	grpcServer := grpc.NewServer(gprcLogger)

	grpcClient, err := grpc.NewClient("localhost:9090", grpc.WithTransportCredentials(insecure.NewCredentials()))
	if err != nil {
		log.Fatal().Err(err).Msg("cannot create grpc client")
	}

	orderpb.RegisterOrderServiceServer(grpcServer, srv)
	srv.ProductServiceClient = orderpb.NewProductServiceClient(grpcClient)

	reflection.Register(grpcServer)

	listener, err := net.Listen("tcp", config.GRPCServerAddress)
	if err != nil {
		log.Fatal().Err(err).Msg("cannot create listener")
	}

	waitGroup.Go(func() error {
		log.Info().Msgf("start gRPC server at %s server", listener.Addr().String())

		err = grpcServer.Serve(listener)
		if err != nil {
			if errors.Is(err, grpc.ErrServerStopped) {
				return nil
			}
			log.Error().Err(err).Msg("gRPC server failed to serve")
			return err
		}

		return nil
	})

	waitGroup.Go(func() error {
		<-ctx.Done()
		log.Info().Msg("graceful shutdown gRPC server")

		grpcServer.GracefulStop()
		log.Info().Msg("gRPC server is stopped")

		return nil
	})

	waitGroup.Go(func() error {
		<-ctx.Done()
		log.Info().Msg("graceful shutdown mongo")
		mongoClient.Disconnect(ctx)
		log.Info().Msg("mongo is stopped")

		return nil
	})
}
