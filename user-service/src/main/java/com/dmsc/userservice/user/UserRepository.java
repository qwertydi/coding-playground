package com.dmsc.userservice.user;

import com.dmsc.userservice.user.model.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<User, Long> {

    Mono<User> findByUsernameAndEmail(String username, String email);

    Mono<User> findByUsername(String username);
}
