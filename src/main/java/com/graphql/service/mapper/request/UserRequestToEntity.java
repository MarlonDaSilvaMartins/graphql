package com.graphql.service.mapper.request;

import com.graphql.repository.user.UserEntity;
import com.graphql.service.user.request.UserRequest;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserRequestToEntity {
    
    public static UserEntity mapFrom(UserRequest userRequest){
        return UserEntity.builder()
            .name(userRequest.name())
            .email(userRequest.email())
            .build();
    }
}