package com.ciandt.summit.playlist.adapter.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Playlists")
public class PlayListEntity {

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

    public PlayListEntity() {
    }

    public PlayListEntity(UUID id, List<MusicEntity> musicEntity) {
        this.id = id;
        this.musics = musicEntity;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<MusicEntity> getMusics() {
        return musics;
    }

    public void setMusics(List<MusicEntity> musics) {
        this.musics = musics;
    }

}
