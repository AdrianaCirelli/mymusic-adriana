package com.ciandt.summit.user;


import java.util.UUID;

public class UserModel {

    private UUID id;

    private String name;

    private TipoUsuarioModel tipoUsuario;

    private PlaylistModel playlist;


    public UserModel() {
    }

    public UserModel(UUID id, String name, TipoUsuarioModel tipoUsuario, PlaylistModel playlist) {

        this.id = id;
        this.name = name;
        this.tipoUsuario = tipoUsuario;
        this.playlist = playlist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public TipoUsuarioModel getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuarioModel tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public PlaylistModel getPlaylist() {
        return playlist;
    }

    public void setPlaylist(PlaylistModel playlist) {
        this.playlist = playlist;
    }
}
