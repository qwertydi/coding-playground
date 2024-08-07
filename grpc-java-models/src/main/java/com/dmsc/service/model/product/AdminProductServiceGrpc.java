package com.dmsc.service.model.product;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.61.1)",
    comments = "Source: product_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AdminProductServiceGrpc {

  private AdminProductServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "products.AdminProductService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.dmsc.service.model.product.Product,
      com.dmsc.service.model.product.ProductResponse> getAddMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Add",
      requestType = com.dmsc.service.model.product.Product.class,
      responseType = com.dmsc.service.model.product.ProductResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.dmsc.service.model.product.Product,
      com.dmsc.service.model.product.ProductResponse> getAddMethod() {
    io.grpc.MethodDescriptor<com.dmsc.service.model.product.Product, com.dmsc.service.model.product.ProductResponse> getAddMethod;
    if ((getAddMethod = AdminProductServiceGrpc.getAddMethod) == null) {
      synchronized (AdminProductServiceGrpc.class) {
        if ((getAddMethod = AdminProductServiceGrpc.getAddMethod) == null) {
          AdminProductServiceGrpc.getAddMethod = getAddMethod =
              io.grpc.MethodDescriptor.<com.dmsc.service.model.product.Product, com.dmsc.service.model.product.ProductResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Add"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dmsc.service.model.product.Product.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dmsc.service.model.product.ProductResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AdminProductServiceMethodDescriptorSupplier("Add"))
              .build();
        }
      }
    }
    return getAddMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.dmsc.service.model.product.ItemRequest,
      com.google.protobuf.Empty> getDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Delete",
      requestType = com.dmsc.service.model.product.ItemRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.dmsc.service.model.product.ItemRequest,
      com.google.protobuf.Empty> getDeleteMethod() {
    io.grpc.MethodDescriptor<com.dmsc.service.model.product.ItemRequest, com.google.protobuf.Empty> getDeleteMethod;
    if ((getDeleteMethod = AdminProductServiceGrpc.getDeleteMethod) == null) {
      synchronized (AdminProductServiceGrpc.class) {
        if ((getDeleteMethod = AdminProductServiceGrpc.getDeleteMethod) == null) {
          AdminProductServiceGrpc.getDeleteMethod = getDeleteMethod =
              io.grpc.MethodDescriptor.<com.dmsc.service.model.product.ItemRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Delete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dmsc.service.model.product.ItemRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new AdminProductServiceMethodDescriptorSupplier("Delete"))
              .build();
        }
      }
    }
    return getDeleteMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AdminProductServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AdminProductServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AdminProductServiceStub>() {
        @java.lang.Override
        public AdminProductServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AdminProductServiceStub(channel, callOptions);
        }
      };
    return AdminProductServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AdminProductServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AdminProductServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AdminProductServiceBlockingStub>() {
        @java.lang.Override
        public AdminProductServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AdminProductServiceBlockingStub(channel, callOptions);
        }
      };
    return AdminProductServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AdminProductServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AdminProductServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AdminProductServiceFutureStub>() {
        @java.lang.Override
        public AdminProductServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AdminProductServiceFutureStub(channel, callOptions);
        }
      };
    return AdminProductServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void add(com.dmsc.service.model.product.Product request,
        io.grpc.stub.StreamObserver<com.dmsc.service.model.product.ProductResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddMethod(), responseObserver);
    }

    /**
     */
    default void delete(com.dmsc.service.model.product.ItemRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AdminProductService.
   */
  public static abstract class AdminProductServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return AdminProductServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AdminProductService.
   */
  public static final class AdminProductServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AdminProductServiceStub> {
    private AdminProductServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdminProductServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AdminProductServiceStub(channel, callOptions);
    }

    /**
     */
    public void add(com.dmsc.service.model.product.Product request,
        io.grpc.stub.StreamObserver<com.dmsc.service.model.product.ProductResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delete(com.dmsc.service.model.product.ItemRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AdminProductService.
   */
  public static final class AdminProductServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AdminProductServiceBlockingStub> {
    private AdminProductServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdminProductServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AdminProductServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.dmsc.service.model.product.ProductResponse add(com.dmsc.service.model.product.Product request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty delete(com.dmsc.service.model.product.ItemRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AdminProductService.
   */
  public static final class AdminProductServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AdminProductServiceFutureStub> {
    private AdminProductServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdminProductServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AdminProductServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.dmsc.service.model.product.ProductResponse> add(
        com.dmsc.service.model.product.Product request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> delete(
        com.dmsc.service.model.product.ItemRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD = 0;
  private static final int METHODID_DELETE = 1;

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
        case METHODID_ADD:
          serviceImpl.add((com.dmsc.service.model.product.Product) request,
              (io.grpc.stub.StreamObserver<com.dmsc.service.model.product.ProductResponse>) responseObserver);
          break;
        case METHODID_DELETE:
          serviceImpl.delete((com.dmsc.service.model.product.ItemRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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
          getAddMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.dmsc.service.model.product.Product,
              com.dmsc.service.model.product.ProductResponse>(
                service, METHODID_ADD)))
        .addMethod(
          getDeleteMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.dmsc.service.model.product.ItemRequest,
              com.google.protobuf.Empty>(
                service, METHODID_DELETE)))
        .build();
  }

  private static abstract class AdminProductServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AdminProductServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.dmsc.service.model.product.ProductProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AdminProductService");
    }
  }

  private static final class AdminProductServiceFileDescriptorSupplier
      extends AdminProductServiceBaseDescriptorSupplier {
    AdminProductServiceFileDescriptorSupplier() {}
  }

  private static final class AdminProductServiceMethodDescriptorSupplier
      extends AdminProductServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AdminProductServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AdminProductServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AdminProductServiceFileDescriptorSupplier())
              .addMethod(getAddMethod())
              .addMethod(getDeleteMethod())
              .build();
        }
      }
    }
    return result;
  }
}
