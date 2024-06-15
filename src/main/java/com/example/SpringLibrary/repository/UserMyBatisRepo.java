package com.example.SpringLibrary.repository;

import com.example.SpringLibrary.model.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface UserMyBatisRepo {
    void insert(User user);
    Optional<User> findByUsername(@Param("username") String username);
}
