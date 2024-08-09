package com.dmsc.service.model.product;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.61.1)",
    comments = "Source: product_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ProductServiceGrpc {

  private ProductServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "products.ProductService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.dmsc.service.model.product.ListProducts> getListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "List",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.dmsc.service.model.product.ListProducts.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.dmsc.service.model.product.ListProducts> getListMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.dmsc.service.model.product.ListProducts> getListMethod;
    if ((getListMethod = ProductServiceGrpc.getListMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getListMethod = ProductServiceGrpc.getListMethod) == null) {
          ProductServiceGrpc.getListMethod = getListMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.dmsc.service.model.product.ListProducts>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "List"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dmsc.service.model.product.ListProducts.getDefaultInstance()))
              .setSchemaDescriptor(new ProductServiceMethodDescriptorSupplier("List"))
              .build();
        }
      }
    }
    return getListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.dmsc.service.model.product.CategoryRequest,
      com.dmsc.service.model.product.ListProducts> getListByCategoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListByCategory",
      requestType = com.dmsc.service.model.product.CategoryRequest.class,
      responseType = com.dmsc.service.model.product.ListProducts.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.dmsc.service.model.product.CategoryRequest,
      com.dmsc.service.model.product.ListProducts> getListByCategoryMethod() {
    io.grpc.MethodDescriptor<com.dmsc.service.model.product.CategoryRequest, com.dmsc.service.model.product.ListProducts> getListByCategoryMethod;
    if ((getListByCategoryMethod = ProductServiceGrpc.getListByCategoryMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getListByCategoryMethod = ProductServiceGrpc.getListByCategoryMethod) == null) {
          ProductServiceGrpc.getListByCategoryMethod = getListByCategoryMethod =
              io.grpc.MethodDescriptor.<com.dmsc.service.model.product.CategoryRequest, com.dmsc.service.model.product.ListProducts>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListByCategory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dmsc.service.model.product.CategoryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dmsc.service.model.product.ListProducts.getDefaultInstance()))
              .setSchemaDescriptor(new ProductServiceMethodDescriptorSupplier("ListByCategory"))
              .build();
        }
      }
    }
    return getListByCategoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.dmsc.service.model.product.ProductStockQuantity,
      com.google.protobuf.Empty> getIncreaseStockMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "IncreaseStock",
      requestType = com.dmsc.service.model.product.ProductStockQuantity.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.dmsc.service.model.product.ProductStockQuantity,
      com.google.protobuf.Empty> getIncreaseStockMethod() {
    io.grpc.MethodDescriptor<com.dmsc.service.model.product.ProductStockQuantity, com.google.protobuf.Empty> getIncreaseStockMethod;
    if ((getIncreaseStockMethod = ProductServiceGrpc.getIncreaseStockMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getIncreaseStockMethod = ProductServiceGrpc.getIncreaseStockMethod) == null) {
          ProductServiceGrpc.getIncreaseStockMethod = getIncreaseStockMethod =
              io.grpc.MethodDescriptor.<com.dmsc.service.model.product.ProductStockQuantity, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "IncreaseStock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dmsc.service.model.product.ProductStockQuantity.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new ProductServiceMethodDescriptorSupplier("IncreaseStock"))
              .build();
        }
      }
    }
    return getIncreaseStockMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.dmsc.service.model.product.ProductStockQuantity,
      com.google.protobuf.Empty> getDecreaseStockMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DecreaseStock",
      requestType = com.dmsc.service.model.product.ProductStockQuantity.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.dmsc.service.model.product.ProductStockQuantity,
      com.google.protobuf.Empty> getDecreaseStockMethod() {
    io.grpc.MethodDescriptor<com.dmsc.service.model.product.ProductStockQuantity, com.google.protobuf.Empty> getDecreaseStockMethod;
    if ((getDecreaseStockMethod = ProductServiceGrpc.getDecreaseStockMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getDecreaseStockMethod = ProductServiceGrpc.getDecreaseStockMethod) == null) {
          ProductServiceGrpc.getDecreaseStockMethod = getDecreaseStockMethod =
              io.grpc.MethodDescriptor.<com.dmsc.service.model.product.ProductStockQuantity, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DecreaseStock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dmsc.service.model.product.ProductStockQuantity.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new ProductServiceMethodDescriptorSupplier("DecreaseStock"))
              .build();
        }
      }
    }
    return getDecreaseStockMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.dmsc.service.model.product.ItemRequest,
      com.dmsc.service.model.product.ProductResponse> getProductByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ProductById",
      requestType = com.dmsc.service.model.product.ItemRequest.class,
      responseType = com.dmsc.service.model.product.ProductResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.dmsc.service.model.product.ItemRequest,
      com.dmsc.service.model.product.ProductResponse> getProductByIdMethod() {
    io.grpc.MethodDescriptor<com.dmsc.service.model.product.ItemRequest, com.dmsc.service.model.product.ProductResponse> getProductByIdMethod;
    if ((getProductByIdMethod = ProductServiceGrpc.getProductByIdMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getProductByIdMethod = ProductServiceGrpc.getProductByIdMethod) == null) {
          ProductServiceGrpc.getProductByIdMethod = getProductByIdMethod =
              io.grpc.MethodDescriptor.<com.dmsc.service.model.product.ItemRequest, com.dmsc.service.model.product.ProductResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ProductById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dmsc.service.model.product.ItemRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dmsc.service.model.product.ProductResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProductServiceMethodDescriptorSupplier("ProductById"))
              .build();
        }
      }
    }
    return getProductByIdMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProductServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductServiceStub>() {
        @java.lang.Override
        public ProductServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductServiceStub(channel, callOptions);
        }
      };
    return ProductServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProductServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductServiceBlockingStub>() {
        @java.lang.Override
        public ProductServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductServiceBlockingStub(channel, callOptions);
        }
      };
    return ProductServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProductServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductServiceFutureStub>() {
        @java.lang.Override
        public ProductServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductServiceFutureStub(channel, callOptions);
        }
      };
    return ProductServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void list(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.dmsc.service.model.product.ListProducts> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListMethod(), responseObserver);
    }

    /**
     */
    default void listByCategory(com.dmsc.service.model.product.CategoryRequest request,
        io.grpc.stub.StreamObserver<com.dmsc.service.model.product.ListProducts> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListByCategoryMethod(), responseObserver);
    }

    /**
     */
    default void increaseStock(com.dmsc.service.model.product.ProductStockQuantity request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getIncreaseStockMethod(), responseObserver);
    }

    /**
     */
    default void decreaseStock(com.dmsc.service.model.product.ProductStockQuantity request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDecreaseStockMethod(), responseObserver);
    }

    /**
     */
    default void productById(com.dmsc.service.model.product.ItemRequest request,
        io.grpc.stub.StreamObserver<com.dmsc.service.model.product.ProductResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getProductByIdMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ProductService.
   */
  public static abstract class ProductServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ProductServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ProductService.
   */
  public static final class ProductServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ProductServiceStub> {
    private ProductServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductServiceStub(channel, callOptions);
    }

    /**
     */
    public void list(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.dmsc.service.model.product.ListProducts> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listByCategory(com.dmsc.service.model.product.CategoryRequest request,
        io.grpc.stub.StreamObserver<com.dmsc.service.model.product.ListProducts> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListByCategoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void increaseStock(com.dmsc.service.model.product.ProductStockQuantity request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getIncreaseStockMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void decreaseStock(com.dmsc.service.model.product.ProductStockQuantity request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDecreaseStockMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void productById(com.dmsc.service.model.product.ItemRequest request,
        io.grpc.stub.StreamObserver<com.dmsc.service.model.product.ProductResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getProductByIdMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ProductService.
   */
  public static final class ProductServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ProductServiceBlockingStub> {
    private ProductServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.dmsc.service.model.product.ListProducts list(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.dmsc.service.model.product.ListProducts listByCategory(com.dmsc.service.model.product.CategoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListByCategoryMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty increaseStock(com.dmsc.service.model.product.ProductStockQuantity request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getIncreaseStockMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty decreaseStock(com.dmsc.service.model.product.ProductStockQuantity request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDecreaseStockMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.dmsc.service.model.product.ProductResponse productById(com.dmsc.service.model.product.ItemRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getProductByIdMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ProductService.
   */
  public static final class ProductServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ProductServiceFutureStub> {
    private ProductServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.dmsc.service.model.product.ListProducts> list(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.dmsc.service.model.product.ListProducts> listByCategory(
        com.dmsc.service.model.product.CategoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListByCategoryMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> increaseStock(
        com.dmsc.service.model.product.ProductStockQuantity request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getIncreaseStockMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> decreaseStock(
        com.dmsc.service.model.product.ProductStockQuantity request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDecreaseStockMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.dmsc.service.model.product.ProductResponse> productById(
        com.dmsc.service.model.product.ItemRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getProductByIdMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST = 0;
  private static final int METHODID_LIST_BY_CATEGORY = 1;
  private static final int METHODID_INCREASE_STOCK = 2;
  private static final int METHODID_DECREASE_STOCK = 3;
  private static final int METHODID_PRODUCT_BY_ID = 4;

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
        case METHODID_LIST:
          serviceImpl.list((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.dmsc.service.model.product.ListProducts>) responseObserver);
          break;
        case METHODID_LIST_BY_CATEGORY:
          serviceImpl.listByCategory((com.dmsc.service.model.product.CategoryRequest) request,
              (io.grpc.stub.StreamObserver<com.dmsc.service.model.product.ListProducts>) responseObserver);
          break;
        case METHODID_INCREASE_STOCK:
          serviceImpl.increaseStock((com.dmsc.service.model.product.ProductStockQuantity) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_DECREASE_STOCK:
          serviceImpl.decreaseStock((com.dmsc.service.model.product.ProductStockQuantity) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_PRODUCT_BY_ID:
          serviceImpl.productById((com.dmsc.service.model.product.ItemRequest) request,
              (io.grpc.stub.StreamObserver<com.dmsc.service.model.product.ProductResponse>) responseObserver);
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
          getListMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              com.dmsc.service.model.product.ListProducts>(
                service, METHODID_LIST)))
        .addMethod(
          getListByCategoryMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.dmsc.service.model.product.CategoryRequest,
              com.dmsc.service.model.product.ListProducts>(
                service, METHODID_LIST_BY_CATEGORY)))
        .addMethod(
          getIncreaseStockMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.dmsc.service.model.product.ProductStockQuantity,
              com.google.protobuf.Empty>(
                service, METHODID_INCREASE_STOCK)))
        .addMethod(
          getDecreaseStockMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.dmsc.service.model.product.ProductStockQuantity,
              com.google.protobuf.Empty>(
                service, METHODID_DECREASE_STOCK)))
        .addMethod(
          getProductByIdMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.dmsc.service.model.product.ItemRequest,
              com.dmsc.service.model.product.ProductResponse>(
                service, METHODID_PRODUCT_BY_ID)))
        .build();
  }

  private static abstract class ProductServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProductServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.dmsc.service.model.product.ProductProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ProductService");
    }
  }

  private static final class ProductServiceFileDescriptorSupplier
      extends ProductServiceBaseDescriptorSupplier {
    ProductServiceFileDescriptorSupplier() {}
  }

  private static final class ProductServiceMethodDescriptorSupplier
      extends ProductServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ProductServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ProductServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProductServiceFileDescriptorSupplier())
              .addMethod(getListMethod())
              .addMethod(getListByCategoryMethod())
              .addMethod(getIncreaseStockMethod())
              .addMethod(getDecreaseStockMethod())
              .addMethod(getProductByIdMethod())
              .build();
        }
      }
    }
    return result;
  }
}
