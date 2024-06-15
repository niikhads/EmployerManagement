package com.example.SpringLibrary.service.impl;

import com.example.SpringLibrary.exception.CommonException;
import com.example.SpringLibrary.mapper.UserMapper;
import com.example.SpringLibrary.model.dto.request.LoginRequest;
import com.example.SpringLibrary.model.dto.request.RegisterRequest;
import com.example.SpringLibrary.model.dto.response.LoginResponse;
import com.example.SpringLibrary.model.dto.response.RegisterResponse;
import com.example.SpringLibrary.model.entity.User;
import com.example.SpringLibrary.repository.UserMyBatisRepo;
import com.example.SpringLibrary.service.UserService;
import com.example.SpringLibrary.util.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMyBatisRepo userMyBatisRepo;
    private final UserMapper userMapper;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;
    @Override
    public RegisterResponse register(RegisterRequest userRequest) {
         if (!Objects.equals(userRequest.getPassword(), userRequest.getConfirmPassword())) {
         //    throw  new CommonException("1001","password not mached", HttpStatus.BAD_REQUEST);
              return new RegisterResponse("Password is not true");
        }
        Optional<User> byUserName = userMyBatisRepo.findByUsername(userRequest.getUsername());
        if (byUserName.isPresent()) {
           // throw  new CommonException("1002","user dublicated", HttpStatus.BAD_REQUEST);
        }

        User user = userMapper.toUser(userRequest);
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        userMyBatisRepo.insert(user);
        return new RegisterResponse("success");

    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Optional<User> userOptional=getByUsername(loginRequest.getUsername());

        if(userOptional.isEmpty()){
           // throw  new CommonException("1000","user not found", HttpStatus.BAD_REQUEST);

            return LoginResponse.withResponse("user is not exists");
        }
        UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword());
        //authenticationManager.authenticate(authenticationToken);

        String token= jwtProvider.generateToken(userOptional.get());
        return LoginResponse.withToken(token);
    }



    @Override
    public Optional<User> getByUsername(String username) {
        return userMyBatisRepo.findByUsername(username);
    }
}