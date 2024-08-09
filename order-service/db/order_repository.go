package db

import (
	"context"
	"github.com/qwertydi/order-service/pkg/entity"
	"github.com/qwertydi/order-service/util"
	"go.mongodb.org/mongo-driver/bson/primitive"
	"go.mongodb.org/mongo-driver/mongo"
)

type OrderRepository interface {
	Add(appDoc entity.Order, ctx context.Context) (primitive.ObjectID, error)
	List(count int, ctx context.Context) ([]*entity.Order, error)
	GetById(oId primitive.ObjectID, ctx context.Context) (*entity.Order, error)
	Delete(oId primitive.ObjectID, ctx context.Context) (int64, error)
}

type orderRepository struct {
	client *mongo.Client
	config *util.Configuration
}

func NewOrderRepository(config *util.Configuration, client *mongo.Client) OrderRepository {
	return &orderRepository{config: config, client: client}
}

func (o orderRepository) Add(appDoc interface{}, ctx context.Context) (primitive.ObjectID, error) {
	//TODO implement me
	panic("implement me")
}

func (o orderRepository) List(count int, ctx context.Context) ([]*interface{}, error) {
	//TODO implement me
	panic("implement me")
}

func (o orderRepository) GetById(oId primitive.ObjectID, ctx context.Context) (*interface{}, error) {
	//TODO implement me
	panic("implement me")
}

func (o orderRepository) Delete(oId primitive.ObjectID, ctx context.Context) (int64, error) {
	//TODO implement me
	panic("implement me")
}
