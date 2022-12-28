package com.graphql.service.mapper.response;

import com.graphql.repository.user.UserEntity;
import com.graphql.service.user.response.UserResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserEntityToResponse {
    public static UserResponse mapFrom(UserEntity userEntity){
        return UserResponse.builder()
            .id(userEntity.getId())
            .name(userEntity.getName())
            .email(userEntity.getEmail())
            .build();
    }
}