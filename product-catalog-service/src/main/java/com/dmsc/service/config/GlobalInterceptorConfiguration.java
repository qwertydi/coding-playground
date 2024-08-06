package com.dmsc.service.config;

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
}
