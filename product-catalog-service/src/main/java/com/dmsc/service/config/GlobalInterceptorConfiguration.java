package com.dmsc.service.config;

import build.buf.protovalidate.Validator;
import grpcstarter.extensions.validation.GrpcValidationProperties;
import grpcstarter.extensions.validation.ProtoValidateServerInterceptor;
import net.devh.boot.grpc.client.interceptor.GrpcGlobalClientInterceptor;
import net.devh.boot.grpc.server.interceptor.GrpcGlobalServerInterceptor;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalInterceptorConfiguration {

    /**
     * Create an GRPC Interceptor to log entry information.
     * Source: <a href="https://yidongnan.github.io/grpc-spring-boot-starter/en/client/configuration.html">GRPC Spring Boot Starter</a>
     *
     * @return {@link GrpcInterceptor}
     */
    @GrpcGlobalClientInterceptor
    @GrpcGlobalServerInterceptor
    public GrpcInterceptor grpcInterceptor() {
        return new GrpcInterceptor();
    }

    /**
     * ProtoValidateServerInterceptor, for some reason autoconfiguration was working properly.
     * Manually starting the interceptor.
     *
     * @param properties GrpcValidationProperties
     * @return ProtoValidateServerInterceptor
     */
    @GrpcGlobalServerInterceptor
    public ProtoValidateServerInterceptor protoValidateServerInterceptor(GrpcValidationProperties properties) {
        return new ProtoValidateServerInterceptor(new Validator(), properties.getServer().getOrder());
    }
}
