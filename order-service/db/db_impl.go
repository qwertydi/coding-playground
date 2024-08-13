package db

import (
	"context"
	"go.mongodb.org/mongo-driver/mongo"
	"go.mongodb.org/mongo-driver/mongo/options"
	"go.mongodb.org/mongo-driver/mongo/readpref"
)

// MongoClientWrapper is a concrete implementation of MongoClientInterface.
type MongoClientWrapper struct {
	Client *mongo.Client
}

// Database returns a handle to a database in MongoDB.
func (m *MongoClientWrapper) Database(name string, opts ...*options.DatabaseOptions) MongoDatabaseInterface {
	db := m.Client.Database(name, opts...)
	return &MongoDatabaseWrapper{db: db}
}

// Ping checks the connection to the MongoDB server.
func (m *MongoClientWrapper) Ping(ctx context.Context, rp *readpref.ReadPref) error {
	return m.Client.Ping(ctx, rp)
}

// UseSessionWithOptions executes a set of operations within a session.
func (m *MongoClientWrapper) UseSessionWithOptions(ctx context.Context, opts *options.SessionOptions, fn func(mongo.SessionContext) error) error {
	return m.Client.UseSessionWithOptions(ctx, opts, fn)
}

// Disconnect closes the connection to the MongoDB server.
func (m *MongoClientWrapper) Disconnect(ctx context.Context) error {
	return m.Client.Disconnect(ctx)
}

// MongoDatabaseWrapper is a concrete implementation of MongoDatabaseInterface.
type MongoDatabaseWrapper struct {
	db *mongo.Database
}

// Collection returns a handle to a MongoDB collection.
func (m *MongoDatabaseWrapper) Collection(name string, opts ...*options.CollectionOptions) MongoCollectionInterface {
	coll := m.db.Collection(name, opts...)
	return &MongoCollectionWrapper{coll: coll}
}

// MongoCollectionWrapper is a concrete implementation of MongoCollectionInterface.
type MongoCollectionWrapper struct {
	coll *mongo.Collection
}

// FindOne finds a single document in the collection.
func (m *MongoCollectionWrapper) FindOne(ctx context.Context, filter interface{}, opts ...*options.FindOneOptions) MongoSingleResultInterface {
	result := m.coll.FindOne(ctx, filter, opts...)
	return &MongoSingleResultWrapper{result: result}
}

// InsertOne inserts a single document into the collection.
func (m *MongoCollectionWrapper) InsertOne(ctx context.Context, document interface{}, opts ...*options.InsertOneOptions) (*mongo.InsertOneResult, error) {
	return m.coll.InsertOne(ctx, document, opts...)
}

// MongoSingleResultWrapper is a concrete implementation of MongoSingleResultInterface.
type MongoSingleResultWrapper struct {
	result *mongo.SingleResult
}

// Decode decodes a single result into the provided value.
func (m *MongoSingleResultWrapper) Decode(v interface{}) error {
	return m.result.Decode(v)
}
