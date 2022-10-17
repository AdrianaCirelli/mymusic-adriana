package com.ciandt.summit.user.spring.repository.adapters.entity;


import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Usuarios")
public class UserEntity{

    @Id
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name ="Nome")
    private String name;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "TipoUsuarioId", referencedColumnName = "Id")
    private TipoUsuarioEntity tipoUsuario;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PlaylistId", referencedColumnName = "Id")
    private PlaylistEntity playlist;


    public UserEntity() {
    }

    public UserEntity(UUID id, String name, TipoUsuarioEntity tipoUsuario) {
        this.id = id;
        this.name = name;
        this.tipoUsuario = tipoUsuario;
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

    public TipoUsuarioEntity getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuarioEntity tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public PlaylistEntity getPlaylist() {
        return playlist;
    }

    public void setPlaylist(PlaylistEntity playlist) {
        this.playlist = playlist;
    }
}
