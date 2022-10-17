package com.ciandt.summit.user.mapper;


import com.ciandt.summit.user.UserModel;
import com.ciandt.summit.user.rest.consumer.UserDtoResponse;
import com.ciandt.summit.user.spring.repository.adapters.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    public abstract UserEntity convertToUserEntity(UserModel user);


    public abstract UserModel convertToUserModel(UserEntity userEntity);

    public abstract UserDtoResponse converToUserDtoResponse(UserModel userModel);


}
