package com.ciandt.summit.user.rest.adapter.dto.request;

import com.ciandt.summit.user.UserModel;

import java.util.UUID;

public class UserLoginDtoRequest {

    private String username;

    public UserLoginDtoRequest() {
    }

    public UserLoginDtoRequest(String username) {
        this.username = username;
    }

    public UserLoginDtoRequest(UserModel userModel){
        this.username = userModel.getName();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
