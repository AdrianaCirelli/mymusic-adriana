package com.ciandt.summit.user.spring.repository.adapters.entity;


import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Playlists")
public class PlaylistEntity {

    @Id
    @Type(type = "uuid-char")
    private UUID id;

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable (
            name = "PlaylistMusicas",
            joinColumns = @JoinColumn(name = "PlaylistId"),
            inverseJoinColumns = @JoinColumn (name = "MusicaId")
    )
    private List<MusicEntity> musics;

    @OneToOne(mappedBy = "playlist")
    private UserEntity user;

    public PlaylistEntity() {
    }

    public PlaylistEntity(UUID id, UserEntity userEntity) {
        this.id = id;
        this.user = userEntity;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity userEntity) {
        this.user = userEntity;
    }

    public List<MusicEntity> getMusics() {
        return musics;
    }

    public void setMusics(List<MusicEntity> musics) {
        this.musics = musics;
    }
}
