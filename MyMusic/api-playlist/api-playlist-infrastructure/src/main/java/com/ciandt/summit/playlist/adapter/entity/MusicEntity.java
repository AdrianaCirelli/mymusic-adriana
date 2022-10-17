package com.ciandt.summit.playlist.adapter.entity;


import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name ="Musicas")
public class MusicEntity {

    @Id
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "Nome")
    private String name;

    @ManyToOne
    @JoinColumn(name = "ArtistaId", referencedColumnName = "Id")
    private ArtistEntity artist;

    @ManyToMany(mappedBy = "musics")
    private List<PlayListEntity> playListEntity;

    public MusicEntity() {
    }

    public MusicEntity(UUID id, String name, ArtistEntity artist, List<PlayListEntity> playListEntity) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.playListEntity = playListEntity;
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

    public ArtistEntity getArtist() {
        return artist;
    }

    public void setArtist(ArtistEntity artist) {
        this.artist = artist;
    }

    public List<PlayListEntity> getPlayListEntity() {
        return playListEntity;
    }

    public void setPlayListEntity(List<PlayListEntity> playListEntity) {
        this.playListEntity = playListEntity;
    }

    @Override
    public String toString() {
        return "MusicEntity{" +
                "name='" + name + '\'' +
                ", artist=" + artist +
                '}';
    }
}
