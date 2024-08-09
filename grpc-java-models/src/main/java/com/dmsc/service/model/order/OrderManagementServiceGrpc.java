package com.dmsc.service.model.order;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.61.1)",
    comments = "Source: order_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class OrderManagementServiceGrpc {

  private OrderManagementServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "orders.OrderManagementService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.dmsc.service.model.order.CreateOrderRequest,
      com.dmsc.service.model.order.OrderResponse> getCreateOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateOrder",
      requestType = com.dmsc.service.model.order.CreateOrderRequest.class,
      responseType = com.dmsc.service.model.order.OrderResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.dmsc.service.model.order.CreateOrderRequest,
      com.dmsc.service.model.order.OrderResponse> getCreateOrderMethod() {
    io.grpc.MethodDescriptor<com.dmsc.service.model.order.CreateOrderRequest, com.dmsc.service.model.order.OrderResponse> getCreateOrderMethod;
    if ((getCreateOrderMethod = OrderManagementServiceGrpc.getCreateOrderMethod) == null) {
      synchronized (OrderManagementServiceGrpc.class) {
        if ((getCreateOrderMethod = OrderManagementServiceGrpc.getCreateOrderMethod) == null) {
          OrderManagementServiceGrpc.getCreateOrderMethod = getCreateOrderMethod =
              io.grpc.MethodDescriptor.<com.dmsc.service.model.order.CreateOrderRequest, com.dmsc.service.model.order.OrderResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dmsc.service.model.order.CreateOrderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dmsc.service.model.order.OrderResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OrderManagementServiceMethodDescriptorSupplier("CreateOrder"))
              .build();
        }
      }
    }
    return getCreateOrderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.dmsc.service.model.order.OrderItem,
      com.dmsc.service.model.order.OrderResponse> getGetOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetOrder",
      requestType = com.dmsc.service.model.order.OrderItem.class,
      responseType = com.dmsc.service.model.order.OrderResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.dmsc.service.model.order.OrderItem,
      com.dmsc.service.model.order.OrderResponse> getGetOrderMethod() {
    io.grpc.MethodDescriptor<com.dmsc.service.model.order.OrderItem, com.dmsc.service.model.order.OrderResponse> getGetOrderMethod;
    if ((getGetOrderMethod = OrderManagementServiceGrpc.getGetOrderMethod) == null) {
      synchronized (OrderManagementServiceGrpc.class) {
        if ((getGetOrderMethod = OrderManagementServiceGrpc.getGetOrderMethod) == null) {
          OrderManagementServiceGrpc.getGetOrderMethod = getGetOrderMethod =
              io.grpc.MethodDescriptor.<com.dmsc.service.model.order.OrderItem, com.dmsc.service.model.order.OrderResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dmsc.service.model.order.OrderItem.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dmsc.service.model.order.OrderResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OrderManagementServiceMethodDescriptorSupplier("GetOrder"))
              .build();
        }
      }
    }
    return getGetOrderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.dmsc.service.model.order.OrderStatus,
      com.dmsc.service.model.order.OrderResponse> getUpdateOrderStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateOrderStatus",
      requestType = com.dmsc.service.model.order.OrderStatus.class,
      responseType = com.dmsc.service.model.order.OrderResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.dmsc.service.model.order.OrderStatus,
      com.dmsc.service.model.order.OrderResponse> getUpdateOrderStatusMethod() {
    io.grpc.MethodDescriptor<com.dmsc.service.model.order.OrderStatus, com.dmsc.service.model.order.OrderResponse> getUpdateOrderStatusMethod;
    if ((getUpdateOrderStatusMethod = OrderManagementServiceGrpc.getUpdateOrderStatusMethod) == null) {
      synchronized (OrderManagementServiceGrpc.class) {
        if ((getUpdateOrderStatusMethod = OrderManagementServiceGrpc.getUpdateOrderStatusMethod) == null) {
          OrderManagementServiceGrpc.getUpdateOrderStatusMethod = getUpdateOrderStatusMethod =
              io.grpc.MethodDescriptor.<com.dmsc.service.model.order.OrderStatus, com.dmsc.service.model.order.OrderResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateOrderStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dmsc.service.model.order.OrderStatus.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dmsc.service.model.order.OrderResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OrderManagementServiceMethodDescriptorSupplier("UpdateOrderStatus"))
              .build();
        }
      }
    }
    return getUpdateOrderStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static OrderManagementServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrderManagementServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OrderManagementServiceStub>() {
        @java.lang.Override
        public OrderManagementServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OrderManagementServiceStub(channel, callOptions);
        }
      };
    return OrderManagementServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static OrderManagementServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrderManagementServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OrderManagementServiceBlockingStub>() {
        @java.lang.Override
        public OrderManagementServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OrderManagementServiceBlockingStub(channel, callOptions);
        }
      };
    return OrderManagementServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static OrderManagementServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrderManagementServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OrderManagementServiceFutureStub>() {
        @java.lang.Override
        public OrderManagementServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OrderManagementServiceFutureStub(channel, callOptions);
        }
      };
    return OrderManagementServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void createOrder(com.dmsc.service.model.order.CreateOrderRequest request,
        io.grpc.stub.StreamObserver<com.dmsc.service.model.order.OrderResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateOrderMethod(), responseObserver);
    }

    /**
     */
    default void getOrder(com.dmsc.service.model.order.OrderItem request,
        io.grpc.stub.StreamObserver<com.dmsc.service.model.order.OrderResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetOrderMethod(), responseObserver);
    }

    /**
     */
    default void updateOrderStatus(com.dmsc.service.model.order.OrderStatus request,
        io.grpc.stub.StreamObserver<com.dmsc.service.model.order.OrderResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateOrderStatusMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service OrderManagementService.
   */
  public static abstract class OrderManagementServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return OrderManagementServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service OrderManagementService.
   */
  public static final class OrderManagementServiceStub
      extends io.grpc.stub.AbstractAsyncStub<OrderManagementServiceStub> {
    private OrderManagementServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderManagementServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrderManagementServiceStub(channel, callOptions);
    }

    /**
     */
    public void createOrder(com.dmsc.service.model.order.CreateOrderRequest request,
        io.grpc.stub.StreamObserver<com.dmsc.service.model.order.OrderResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateOrderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getOrder(com.dmsc.service.model.order.OrderItem request,
        io.grpc.stub.StreamObserver<com.dmsc.service.model.order.OrderResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetOrderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateOrderStatus(com.dmsc.service.model.order.OrderStatus request,
        io.grpc.stub.StreamObserver<com.dmsc.service.model.order.OrderResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateOrderStatusMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service OrderManagementService.
   */
  public static final class OrderManagementServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<OrderManagementServiceBlockingStub> {
    private OrderManagementServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderManagementServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrderManagementServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.dmsc.service.model.order.OrderResponse createOrder(com.dmsc.service.model.order.CreateOrderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateOrderMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.dmsc.service.model.order.OrderResponse getOrder(com.dmsc.service.model.order.OrderItem request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetOrderMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.dmsc.service.model.order.OrderResponse updateOrderStatus(com.dmsc.service.model.order.OrderStatus request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateOrderStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service OrderManagementService.
   */
  public static final class OrderManagementServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<OrderManagementServiceFutureStub> {
    private OrderManagementServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderManagementServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrderManagementServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.dmsc.service.model.order.OrderResponse> createOrder(
        com.dmsc.service.model.order.CreateOrderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateOrderMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.dmsc.service.model.order.OrderResponse> getOrder(
        com.dmsc.service.model.order.OrderItem request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetOrderMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.dmsc.service.model.order.OrderResponse> updateOrderStatus(
        com.dmsc.service.model.order.OrderStatus request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateOrderStatusMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_ORDER = 0;
  private static final int METHODID_GET_ORDER = 1;
  private static final int METHODID_UPDATE_ORDER_STATUS = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_ORDER:
          serviceImpl.createOrder((com.dmsc.service.model.order.CreateOrderRequest) request,
              (io.grpc.stub.StreamObserver<com.dmsc.service.model.order.OrderResponse>) responseObserver);
          break;
        case METHODID_GET_ORDER:
          serviceImpl.getOrder((com.dmsc.service.model.order.OrderItem) request,
              (io.grpc.stub.StreamObserver<com.dmsc.service.model.order.OrderResponse>) responseObserver);
          break;
        case METHODID_UPDATE_ORDER_STATUS:
          serviceImpl.updateOrderStatus((com.dmsc.service.model.order.OrderStatus) request,
              (io.grpc.stub.StreamObserver<com.dmsc.service.model.order.OrderResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getCreateOrderMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.dmsc.service.model.order.CreateOrderRequest,
              com.dmsc.service.model.order.OrderResponse>(
                service, METHODID_CREATE_ORDER)))
        .addMethod(
          getGetOrderMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.dmsc.service.model.order.OrderItem,
              com.dmsc.service.model.order.OrderResponse>(
                service, METHODID_GET_ORDER)))
        .addMethod(
          getUpdateOrderStatusMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.dmsc.service.model.order.OrderStatus,
              com.dmsc.service.model.order.OrderResponse>(
                service, METHODID_UPDATE_ORDER_STATUS)))
        .build();
  }

  private static abstract class OrderManagementServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    OrderManagementServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.dmsc.service.model.order.OrderProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("OrderManagementService");
    }
  }

  private static final class OrderManagementServiceFileDescriptorSupplier
      extends OrderManagementServiceBaseDescriptorSupplier {
    OrderManagementServiceFileDescriptorSupplier() {}
  }

  private static final class OrderManagementServiceMethodDescriptorSupplier
      extends OrderManagementServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    OrderManagementServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (OrderManagementServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new OrderManagementServiceFileDescriptorSupplier())
              .addMethod(getCreateOrderMethod())
              .addMethod(getGetOrderMethod())
              .addMethod(getUpdateOrderStatusMethod())
              .build();
        }
      }
    }
    return result;
  }
}
