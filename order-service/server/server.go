package server

import (
	orderpb "github.com/qwertydi/order-service/pb"
	"github.com/qwertydi/order-service/util"
	"go.mongodb.org/mongo-driver/mongo"
)

type Server struct {
	orderpb.UnimplementedOrderServiceServer
	orderpb.ProductServiceClient
	config      util.Config
	mongoClient *mongo.Client
}

// NewServer creates a new gRPC server.
func NewServer(config util.Config, mongoClient *mongo.Client) (*Server, error) {
	return &Server{
		config:      config,
		mongoClient: mongoClient,
	}, nil
}
