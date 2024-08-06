package com.dmsc.service.config;

import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.StatusException;
import net.devh.boot.grpc.server.advice.GrpcAdvice;
import net.devh.boot.grpc.server.advice.GrpcExceptionHandler;

@GrpcAdvice
public class GrpcExceptionAdvice {

    @GrpcExceptionHandler
    public Status handleInvalidArgument(IllegalArgumentException e) {
        return Status.INVALID_ARGUMENT.withDescription("Illegal Argument").withCause(e);
    }

    @GrpcExceptionHandler(Exception.class)
    public StatusException handleException(Exception e) {
        Status status = Status.UNKNOWN.withDescription("Generic Error").withCause(e);
        Metadata metadata = new Metadata();
        metadata.put( Metadata.Key.of("error", Metadata.ASCII_STRING_MARSHALLER), e.getMessage());
        return status.asException(metadata);
    }

}
