package com.example.sleuth.mongo;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class UserHandler {

    private final UserRepository userRepository;

    public UserHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<ServerResponse> save(ServerRequest request) {
        return userRepository.saveAll(request.bodyToMono(User.class)).then(ServerResponse.ok().body(Mono.just("ok\n"), String.class));
    }
}
