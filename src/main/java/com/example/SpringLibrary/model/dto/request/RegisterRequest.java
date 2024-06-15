package com.example.SpringLibrary.model.dto.request;

import lombok.Data;

@Data
public class RegisterRequest {
    private String userId;
    private String username;
    private String nameUser;
    private String surnameUser;
    private String email;
    private String password;
    private String confirmPassword;
}