package com.ciandt.summit.user.rest.adapter.dto.response;

import com.ciandt.summit.user.UserModel;

import java.util.UUID;

public class UserLoginDtoResponse {

    private UUID id;
    private String name;

    public UserLoginDtoResponse() {
    }

    public UserLoginDtoResponse(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserLoginDtoResponse(UserModel userModel){
        this.id = userModel.getId();
        this.name = userModel.getName();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
