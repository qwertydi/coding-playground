package com.dmsc.service.utils;

import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.protobuf.ProtoUtils;
import io.grpc.reflection.v1alpha.ErrorResponse;
import io.grpc.stub.StreamObserver;
import org.springframework.util.StringUtils;

public final class ValidationUtils {
    private ValidationUtils() {
        // prevent initialization
    }

    public static <T> boolean failedValidations(String id, StreamObserver<T> responseObserver) {
        if (!StringUtils.hasText(id)) {
            Metadata.Key<ErrorResponse> errorResponseKey = ProtoUtils.keyForProto(ErrorResponse.getDefaultInstance());
            ErrorResponse errorResponse = ErrorResponse.newBuilder()
                    .setErrorMessage("Missing field")
                    .build();
            Metadata metadata = new Metadata();
            metadata.put(errorResponseKey, errorResponse);
            responseObserver.onError(Status.INVALID_ARGUMENT.withDescription("Missing field")
                    .asRuntimeException(metadata));
            return true;
        }
        return false;
    }

}
