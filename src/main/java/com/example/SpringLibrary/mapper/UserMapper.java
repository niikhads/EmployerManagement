package com.example.SpringLibrary.mapper;

import com.example.SpringLibrary.model.dto.request.RegisterRequest;
import com.example.SpringLibrary.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring",imports={LocalDateTime.class})
public interface UserMapper {

    @Mapping(target = "createdAtu",expression = "java(LocalDateTime.now())")
    @Mapping(target = "updatedAtu",expression = "java(LocalDateTime.now())")
    User toUser(RegisterRequest userRequest);
}