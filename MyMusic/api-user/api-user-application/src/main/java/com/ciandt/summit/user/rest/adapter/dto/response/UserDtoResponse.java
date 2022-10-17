package com.ciandt.summit.user.rest.adapter.dto.response;

import com.ciandt.summit.user.UserModel;

import java.util.UUID;

public class UserDtoResponse {

    private UUID id;

    private String name;

    private TipoUsuarioDtoResponse tipoUsuario;

    private PlaylistDtoResponse playlist;

    public UserDtoResponse() {
    }

    public UserDtoResponse(UUID id, String name, TipoUsuarioDtoResponse tipoUsuarioDto, PlaylistDtoResponse playlistUserDtoResponse) {
        this.id = id;
        this.name = name;
        this.tipoUsuario = tipoUsuarioDto;
        this.playlist = playlistUserDtoResponse;
    }

    public UserDtoResponse(UserModel userModel){
        this.id = userModel.getId();
        this.name = userModel.getName();
        // TODO fazer construtuor em TipoUsuarioDto que receb um TipoUsuarioModel e sete os atributos
        this.tipoUsuario = new TipoUsuarioDtoResponse(userModel.getTipoUsuario().getId(), userModel.getTipoUsuario().getDescricao());
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

    public TipoUsuarioDtoResponse getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuarioDtoResponse tipoUsuarioDto) {
        this.tipoUsuario = tipoUsuarioDto;
    }
}
