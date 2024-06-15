package com.example.SpringLibrary.service;


import com.example.SpringLibrary.model.dto.request.LoginRequest;
import com.example.SpringLibrary.model.dto.request.RegisterRequest;
import com.example.SpringLibrary.model.dto.response.LoginResponse;
import com.example.SpringLibrary.model.dto.response.RegisterResponse;
import com.example.SpringLibrary.model.entity.User;

import java.util.Optional;

public interface UserService {
    RegisterResponse register(RegisterRequest registerRequest);
    LoginResponse login(LoginRequest loginRequest);
    Optional<User> getByUsername(String username);
}
