package entity

import "context"

type OrderProduct struct {
	ProductId string `json:"product_id" bson:"product_id"`
	Quantity  int64  `json:"quantity" bson:"quantity"`
	Status    string `json:"status" bson:"status"`
}

type OrderProductRepository interface {
	InsertOne(ctx context.Context, u *OrderProduct) (*OrderProduct, error)
	FindOne(ctx context.Context, id string) (*OrderProduct, error)
	GetAllWithPage(ctx context.Context, rp int64, p int64, filter interface{}, setsort interface{}) ([]OrderProduct, int64, error)
	UpdateOne(ctx context.Context, user *OrderProduct, id string) (*OrderProduct, error)
}

type OOrderProductUsecase interface {
	InsertOne(ctx context.Context, u *OrderProduct) (*OrderProduct, error)
	FindOne(ctx context.Context, id string) (*OrderProduct, error)
	GetAllWithPage(ctx context.Context, rp int64, p int64, filter interface{}, setsort interface{}) ([]OrderProduct, int64, error)
	UpdateOne(ctx context.Context, user *OrderProduct, id string) (*OrderProduct, error)
}
