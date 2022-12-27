package com.graphql.controller;

import com.graphql.controller.input.UserInput;
import com.graphql.insfrastructure.user.UserEntity;
import com.graphql.insfrastructure.user.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@AllArgsConstructor
public class UserController {
    
    private final UserRepository userRepository;
    
    @QueryMapping
    Iterable<UserEntity> users(){
        return userRepository.findAll();
    }
    
    @MutationMapping
    UserEntity createUser(@Argument UserInput input) {
        return userRepository.save(UserEntity.builder()
            .name(input.name())
            .email(input.email())
            .build());
    }
}