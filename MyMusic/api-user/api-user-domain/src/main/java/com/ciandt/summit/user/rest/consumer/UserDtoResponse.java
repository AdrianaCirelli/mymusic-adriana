package com.ciandt.summit.user.rest.consumer;

import com.ciandt.summit.user.UserModel;

import java.util.UUID;

public class UserDtoResponse {

    private UUID id;

    private String name;

    private PlaylistDtoResponse playlist;

    public UserDtoResponse() {
    }

    public UserDtoResponse(UUID id, String name, PlaylistDtoResponse playlistUserDtoResponse) {
        this.id = id;
        this.name = name;
        this.playlist = playlistUserDtoResponse;
    }

    public UserDtoResponse(UserModel userModel){
        this.id = userModel.getId();
        this.name = userModel.getName();
        this.playlist = new PlaylistDtoResponse(userModel.getPlaylist());
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

    public PlaylistDtoResponse getPlaylist() {
        return playlist;
    }

    public void setPlaylist(PlaylistDtoResponse playlist) {
        this.playlist = playlist;
    }
}
