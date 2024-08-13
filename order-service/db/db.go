package db

import (
	"context"
	"go.mongodb.org/mongo-driver/mongo"
	"go.mongodb.org/mongo-driver/mongo/options"
	"go.mongodb.org/mongo-driver/mongo/readpref"
)

// MongoClientInterface defines the methods for interacting with MongoDB.
type MongoClientInterface interface {
	// Database returns a handle to a MongoDB database.
	Database(name string, opts ...*options.DatabaseOptions) MongoDatabaseInterface

	// Ping verifies if the client can connect to the MongoDB server.
	Ping(ctx context.Context, rp *readpref.ReadPref) error

	// Disconnect closes the connection to the MongoDB server.
	Disconnect(ctx context.Context) error

	UseSessionWithOptions(ctx context.Context, opts *options.SessionOptions, fn func(mongo.SessionContext) error) error
}

// MongoDatabaseInterface defines methods for interacting with a MongoDB database.
type MongoDatabaseInterface interface {
	Collection(name string, opts ...*options.CollectionOptions) MongoCollectionInterface
	// Add other methods from mongo.Database as needed
}

// MongoCollectionInterface defines methods for interacting with a MongoDB collection.
type MongoCollectionInterface interface {
	FindOne(ctx context.Context, filter interface{}, opts ...*options.FindOneOptions) MongoSingleResultInterface
	InsertOne(ctx context.Context, document interface{}, opts ...*options.InsertOneOptions) (*mongo.InsertOneResult, error)
	// Add other methods from mongo.Collection as needed
}

// MongoSingleResultInterface defines methods for working with a single result.
type MongoSingleResultInterface interface {
	Decode(v interface{}) error
	// Add other methods from mongo.SingleResult as needed
}
