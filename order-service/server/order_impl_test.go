package server

import (
	"context"
	"fmt"
	"github.com/golang/mock/gomock"
	"github.com/qwertydi/order-service/mocks"
	orderpb "github.com/qwertydi/order-service/pb"
	"github.com/qwertydi/order-service/pkg/entity"
	"github.com/qwertydi/order-service/util"
	"go.mongodb.org/mongo-driver/bson"
	"go.mongodb.org/mongo-driver/bson/primitive"
	"go.mongodb.org/mongo-driver/mongo"
	"go.mongodb.org/mongo-driver/mongo/options"
	"testing"
	"time"
)

func TestCreateOrder(t *testing.T) {
	ctrl := gomock.NewController(t)
	defer ctrl.Finish()

	// Mock MongoDB client
	mockMongoClient := mocks.NewMockMongoClientInterface(ctrl)
	mockCollection := mocks.NewMockMongoCollectionInterface(ctrl)
	mockDatabase := mocks.NewMockMongoDatabaseInterface(ctrl)

	// Initialize the server with the mock client
	server := &Server{
		mongoClient: mockMongoClient,
		config:      util.Config{DBName: "test_db"},
		// ProductServiceClient: mockProductServiceClient,
	}

	// Sample data to return
	/*
		order := entity.Order{
			UserId:      "user123",
			OrderStatus: orderpb.ORDER_STATUS_PENDING.String(),
			CreatedAt:   time.Now(),
			UpdatedAt:   time.Now(),
			Products: []entity.OrderProduct{
				{Status: orderpb.ORDER_STATUS_PENDING.String(), Quantity: 2, ProductId: "prod1"},
			},
		}
	*/

	orderItem := &orderpb.CreateOrderRequest{
		Products: []*orderpb.OrderProduct{
			{
				ProductId: "1",
				Quantity:  1,
				Status:    orderpb.ORDER_STATUS_PENDING,
			},
		},
		UserId: "userId",
	}

	mockMongoClient.EXPECT().
		Database("test_db").
		Return(mockDatabase)
	mockDatabase.EXPECT().
		Collection("order").
		Return(mockCollection)
	mockMongoClient.EXPECT().
		UseSessionWithOptions(gomock.Any(), gomock.Any(), gomock.Any()).
		DoAndReturn(func(ctx context.Context, opts *options.SessionOptions, fn func(mongo.SessionContext) error) error {
			return fn(context.TODO()) // isto aqui devia de ter um mockSession ou similar, mas n tou a conseguir desencaracilhar isto
		})

	// mockSessionContext.On("StartTransaction", gomock.Any()).Return(nil)
	// mockSessionContext.On("CommitTransaction", gomock.Any()).Return(nil)
	// mockSessionContext.On("AbortTransaction", gomock.Any()).Return(nil)

	mockCollection.EXPECT().
		InsertOne(gomock.Any(), gomock.Any()).
		Return(&mongo.InsertOneResult{}, nil)

	// mockProductServiceClient.EXPECT().
	// 	DecreaseStock(gomock.Any(), gomock.Any()).
	//	Return(&orderpb.DecreaseStockResponse{}, nil)

	// Call the GetOrder function
	resp, err := server.CreateOrder(context.TODO(), orderItem)

	// Assertions
	if err != nil {
		t.Fatalf("expected no error, got %v", err)
	}

	if resp.UserId != orderItem.UserId {
		t.Errorf("expected user ID %v, got %v", orderItem.UserId, resp.Id)
	}

	if len(resp.Products) != len(orderItem.Products) {
		t.Errorf("expected %v products, got %v", len(orderItem.Products), len(resp.Products))
	}
}

func TestGetOrder(t *testing.T) {
	ctrl := gomock.NewController(t)
	defer ctrl.Finish()

	// Mock MongoDB client
	mockMongoClient := mocks.NewMockMongoClientInterface(ctrl)
	mockCollection := mocks.NewMockMongoCollectionInterface(ctrl)
	mockDatabase := mocks.NewMockMongoDatabaseInterface(ctrl)
	mockSingleResult := mocks.NewMockMongoSingleResultInterface(ctrl)

	// Initialize the server with the mock client
	server := &Server{
		mongoClient: mockMongoClient,
		config:      util.Config{DBName: "test_db"},
	}

	// Sample input
	orderID := primitive.NewObjectID()
	orderItem := &orderpb.OrderItem{Id: orderID.Hex()}

	// Sample data to return
	order := &entity.Order{
		ID:          orderID,
		UserId:      "user123",
		OrderStatus: orderpb.ORDER_STATUS_PENDING.String(),
		CreatedAt:   time.Now(),
		UpdatedAt:   time.Now(),
		Products: []entity.OrderProduct{
			{Status: orderpb.ORDER_STATUS_PENDING.String(), Quantity: 2, ProductId: "prod1"},
		},
	}

	// Mock behavior: Collection call returns mock collection
	mockMongoClient.EXPECT().Database("test_db").Return(mockDatabase)
	mockDatabase.EXPECT().Collection("order").Return(mockCollection)
	mockCollection.EXPECT().FindOne(context.TODO(), bson.M{"_id": orderID}).Return(mockSingleResult)
	mockSingleResult.EXPECT().Decode(gomock.Any()).DoAndReturn(func(v interface{}) error {
		if orderPtr, ok := v.(*entity.Order); ok {
			*orderPtr = *order
			return nil
		}
		return fmt.Errorf("unexpected type: %T", v)
	})

	// Call the GetOrder function
	resp, err := server.GetOrder(context.TODO(), orderItem)

	// Assertions
	if err != nil {
		t.Fatalf("expected no error, got %v", err)
	}

	if resp.Id != orderItem.Id {
		t.Errorf("expected order ID %v, got %v", orderItem.Id, resp.Id)
	}

	if resp.UserId != order.UserId {
		t.Errorf("expected user ID %v, got %v", order.UserId, resp.UserId)
	}

	if len(resp.Products) != len(order.Products) {
		t.Errorf("expected %v products, got %v", len(order.Products), len(resp.Products))
	}
}
