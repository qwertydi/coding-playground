package server

import (
	"github.com/qwertydi/order-service/db"
	orderpb "github.com/qwertydi/order-service/pb"
	"github.com/qwertydi/order-service/util"
)

type Server struct {
	orderpb.UnimplementedOrderServiceServer
	orderpb.ProductServiceClient
	config      util.Config
	mongoClient db.MongoClientInterface
}

// NewServer creates a new gRPC server.
func NewServer(config util.Config, mongoClient db.MongoClientInterface) (*Server, error) {
	return &Server{
		config:      config,
		mongoClient: mongoClient,
	}, nil
}
