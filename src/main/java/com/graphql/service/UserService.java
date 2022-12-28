package com.graphql.service;

import com.graphql.repository.user.UserRepository;
import com.graphql.service.mapper.request.UserRequestToEntity;
import com.graphql.service.mapper.response.UserEntityToResponse;
import com.graphql.service.user.request.UserRequest;
import com.graphql.service.user.response.UserResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    
    public Flux<UserResponse> getAllUsers(){
        return userRepository.findAll()
            .map(UserEntityToResponse::mapFrom);
    }
    
    public Mono<UserResponse> createUser(UserRequest userRequest){
        return userRepository.save(UserRequestToEntity.mapFrom(userRequest))
            .map(UserEntityToResponse::mapFrom);
    }
    
}