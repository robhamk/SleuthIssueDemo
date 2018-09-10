package com.example.sleuth.router;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.example.sleuth.echo.EchoHandler;
import com.example.sleuth.mongo.UserHandler;

@Configuration
public class Router {
    @Bean
    public RouterFunction<ServerResponse> echoRouter(EchoHandler echoHandler) {
        return route(POST("/echo"), echoHandler::echo);
    }

    @Bean
    public RouterFunction<ServerResponse> userRouter(UserHandler userHandler) {
        return route(POST("/user"), userHandler::save);
    }
}
