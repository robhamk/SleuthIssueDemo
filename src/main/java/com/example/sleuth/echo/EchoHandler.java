package com.example.sleuth.echo;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class EchoHandler {

    public Mono<ServerResponse> echo(ServerRequest request) {
        return ServerResponse.ok().body(request.bodyToMono(String.class).map(s -> s + "\n"), String.class);
    }

}
