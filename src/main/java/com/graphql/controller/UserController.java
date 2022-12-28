package com.graphql.controller;

import com.graphql.service.UserService;
import com.graphql.service.user.request.UserRequest;
import com.graphql.service.user.response.UserResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Controller
@AllArgsConstructor
public class UserController {
    
    private final UserService userService;
    
    @QueryMapping
    Flux<UserResponse> users(){
        return userService.getAllUsers();
    }
    
    @MutationMapping
    Mono<UserResponse> createUser(@Argument
    UserRequest userRequest) {
        return userService.createUser(userRequest);
    }
}