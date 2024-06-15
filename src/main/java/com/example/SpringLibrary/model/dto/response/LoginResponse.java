package com.example.SpringLibrary.model.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class LoginResponse {
    private String response;
    private String token;
  public static LoginResponse withToken(String token){
   LoginResponse loginResponse= new LoginResponse();
   loginResponse.setToken(token);
   return loginResponse;
  }
    public static LoginResponse withResponse(String response){
        LoginResponse loginResponse= new LoginResponse();
        loginResponse.setResponse(response);
        return loginResponse;
    }
}