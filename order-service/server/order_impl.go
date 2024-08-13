package server

import (
	"context"
	orderpb "github.com/qwertydi/order-service/pb"
	"github.com/qwertydi/order-service/pkg/entity"
	"go.mongodb.org/mongo-driver/bson"
	"go.mongodb.org/mongo-driver/bson/primitive"
	"go.mongodb.org/mongo-driver/mongo"
	"go.mongodb.org/mongo-driver/mongo/options"
	"go.mongodb.org/mongo-driver/mongo/readconcern"
	"go.mongodb.org/mongo-driver/mongo/readpref"
	"go.mongodb.org/mongo-driver/mongo/writeconcern"
	"google.golang.org/protobuf/types/known/timestamppb"
	"log"
	"time"
)

func (server *Server) CreateOrder(ctx context.Context, request *orderpb.CreateOrderRequest) (*orderpb.OrderResponse, error) {
	order := entity.Order{
		ID:          primitive.NewObjectID(),
		UserId:      request.UserId,
		OrderStatus: orderpb.ORDER_STATUS_PENDING.String(),
		CreatedAt:   time.Now(),
		UpdatedAt:   time.Now(),
	}

	collection := server.mongoClient.Database(server.config.DBName).Collection("order")

	opts := options.Session().
		SetDefaultReadPreference(readpref.Secondary()).
		SetDefaultReadConcern(readconcern.Majority()).
		SetDefaultWriteConcern(writeconcern.New(writeconcern.WMajority(), writeconcern.WTimeout(1000)))

	sessionRequest := func(sessionContext mongo.SessionContext) error {
		err := sessionContext.StartTransaction(options.Transaction().
			SetReadConcern(readconcern.Snapshot()).
			SetWriteConcern(writeconcern.Majority()),
		)

		for _, element := range request.GetProducts() {
			order.Products = append(order.Products, entity.OrderProduct{
				ProductId: element.ProductId,
				Quantity:  element.Quantity,
			})
			_, err := server.ProductServiceClient.DecreaseStock(ctx, &orderpb.ProductStockQuantity{
				Id:       element.ProductId,
				Quantity: int32(element.Quantity),
			})
			if err != nil {
				return err
			}
		}

		_, err = collection.InsertOne(ctx, order)
		// TODO Attempt to decrease stocks, on error, stop
		if err != nil {
			_ = sessionContext.AbortTransaction(sessionContext)
			log.Println("caught exception during transaction, aborting.")
			return err
		}

		if err = sessionContext.CommitTransaction(sessionContext); err != nil {
			return err
		}

		return nil
	}

	err := server.mongoClient.UseSessionWithOptions(ctx, opts, sessionRequest)
	if err != nil {
		return nil, err
	}

	return &orderpb.OrderResponse{
		Id:        order.ID.Hex(),
		UserId:    order.UserId,
		Products:  request.GetProducts(),
		Status:    Enum(order.OrderStatus, orderpb.ORDER_STATUS_value, orderpb.ORDER_STATUS_PENDING),
		CreatedAt: timestamppb.New(order.CreatedAt),
		UpdatedAt: timestamppb.New(order.UpdatedAt),
	}, nil
}

func (server *Server) GetOrder(ctx context.Context, item *orderpb.OrderItem) (*orderpb.OrderResponse, error) {
	collection := server.mongoClient.Database(server.config.DBName).Collection("order")

	hex, err := primitive.ObjectIDFromHex(item.Id)
	if err != nil {
		return nil, err
	}

	result := entity.Order{}
	err = collection.FindOne(ctx, bson.M{"_id": hex}).Decode(&result)
	if err != nil {
		return nil, err
	}

	response := &orderpb.OrderResponse{
		Id:        result.ID.Hex(),
		UserId:    result.UserId,
		Status:    Enum(result.OrderStatus, orderpb.ORDER_STATUS_value, orderpb.ORDER_STATUS_PENDING),
		CreatedAt: timestamppb.New(result.CreatedAt),
		UpdatedAt: timestamppb.New(result.UpdatedAt),
	}
	for _, element := range result.Products {
		response.Products = append(response.GetProducts(), &orderpb.OrderProduct{
			Status:    Enum(element.Status, orderpb.ORDER_STATUS_value, orderpb.ORDER_STATUS_PENDING),
			Quantity:  element.Quantity,
			ProductId: element.ProductId,
		})
	}

	return response, nil
}

func (server *Server) UpdateOrderStatus(ctx context.Context, status *orderpb.OrderStatus) (*orderpb.OrderResponse, error) {
	//TODO implement me
	panic("implement me")
}

func Enum[T ~string, PB ~int32](val T, pbmap map[string]int32, dft PB) PB {
	v, ok := pbmap[string(val)]
	if !ok {
		return dft
	}
	return PB(v)
}
