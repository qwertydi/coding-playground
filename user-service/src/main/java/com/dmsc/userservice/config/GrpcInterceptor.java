package com.dmsc.userservice.config;

import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GrpcInterceptor implements ServerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(GrpcInterceptor.class);

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> serverCall,
                                                                 Metadata metadata,
                                                                 ServerCallHandler<ReqT, RespT> serverCallHandler) {
        logger.info("Method: {}", serverCall.getMethodDescriptor().getFullMethodName());

        return serverCallHandler.startCall(serverCall, metadata);
    }
}
