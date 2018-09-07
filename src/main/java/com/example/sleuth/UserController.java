package com.example.sleuth;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sleuth.mongo.User;
import com.example.sleuth.mongo.UserRepository;

import reactor.core.publisher.Mono;

@RestController
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(path = "/user")
    public Mono<String> create(@RequestBody User user) {
        return userRepository.save(user).map(s -> "ok\n");
    }
}
