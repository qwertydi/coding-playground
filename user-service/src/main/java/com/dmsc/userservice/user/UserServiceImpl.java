package com.dmsc.userservice.user;

import com.dmsc.service.model.user.AuthenticateUser;
import com.dmsc.service.model.user.CreateUser;
import com.dmsc.service.model.user.UserResponse;
import com.dmsc.service.model.user.UserServiceGrpc;
import com.dmsc.userservice.user.model.User;
import com.google.protobuf.Empty;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.security.crypto.password.PasswordEncoder;
import reactor.core.publisher.Mono;

@GrpcService
public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void create(CreateUser request, StreamObserver<UserResponse> responseObserver) {
        checkUser(request)
                .flatMap(userExists -> {
                    if (userExists == Boolean.TRUE) {
                        return Mono.error(Status.ALREADY_EXISTS.asRuntimeException());
                    }

                    return userRepository.save(User.builder()
                            .name(request.getName())
                            .username(request.getUsername())
                            .email(request.getEmail())
                            .password(passwordEncoder.encode(request.getPassword()))
                            .build());

                })
                .map(createdUser -> UserResponse.newBuilder()
                        .setEmail(createdUser.getEmail())
                        .setName(createdUser.getName())
                        .build())
                .subscribe(
                        responseObserver::onNext,
                        responseObserver::onError,
                        responseObserver::onCompleted
                );
    }

    /*
     Other option:
        .flatMap(u -> Mono.error(Status.ALREADY_EXISTS.asRuntimeException()))
        .switchIfEmpty(Mono.defer(() -> userRepository.save(User.builder()
                        .name(request.getName())
                        .username(request.getUsername())
                        .email(request.getEmail())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .build())))
        .cast(User.class);
     */
    public Mono<Boolean> checkUser(CreateUser request) {
        return userRepository.findByUsernameAndEmail(request.getUsername(), request.getEmail())
                .hasElement();
    }

    @Override
    public void getUser(Empty request, StreamObserver<UserResponse> responseObserver) {
        // todo fetch user from session
        super.getUser(request, responseObserver);
    }

    @Override
    public void getUserLogin(AuthenticateUser request, StreamObserver<UserResponse> responseObserver) {
        userRepository.findByUsername(request.getUsername())
                .switchIfEmpty(Mono.defer(() -> Mono.error(Status.NOT_FOUND.asRuntimeException())))
                .flatMap(user -> {
                    if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                        return Mono.error(Status.NOT_FOUND.asRuntimeException());
                    }
                    return Mono.just(user);
                })
                .map(u -> UserResponse.newBuilder()
                        .setName(u.getName())
                        .setEmail(u.getEmail())
                        .setUsername(u.getUsername())
                        .setId(String.valueOf(u.getId()))
                        .build())
                .subscribe(
                        responseObserver::onNext,
                        responseObserver::onError,
                        responseObserver::onCompleted
                );
    }
}
