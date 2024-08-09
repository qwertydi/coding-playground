package entity

import (
	"context"
	"go.mongodb.org/mongo-driver/bson/primitive"
	"time"
)

type Order struct {
	ID          primitive.ObjectID `json:"id" bson:"_id"`
	UserId      string             `json:"user_id" bson:"user_id"`
	OrderStatus string             `json:"order_status" bson:"order_status"`
	CreatedAt   time.Time          `json:"created_at" bson:"created_at"`
	UpdatedAt   time.Time          `json:"updated_at" bson:"updated_at"`
	Products    []OrderProduct     `json:"products" bson:"products"`
}

type OrderRepository interface {
	InsertOne(ctx context.Context, u *Order) (*Order, error)
	FindOne(ctx context.Context, id string) (*Order, error)
	GetAllWithPage(ctx context.Context, rp int64, p int64, filter interface{}, setsort interface{}) ([]Order, int64, error)
	UpdateOne(ctx context.Context, user *Order, id string) (*Order, error)
}

type OrderUsecase interface {
	InsertOne(ctx context.Context, u *Order) (*Order, error)
	FindOne(ctx context.Context, id string) (*Order, error)
	GetAllWithPage(ctx context.Context, rp int64, p int64, filter interface{}, setsort interface{}) ([]Order, int64, error)
	UpdateOne(ctx context.Context, user *Order, id string) (*Order, error)
}
