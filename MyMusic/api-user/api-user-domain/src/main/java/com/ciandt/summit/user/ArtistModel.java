package com.ciandt.summit.user;

import java.util.List;
import java.util.UUID;

public class ArtistModel {

    private UUID id;
    private String name;
    private List<MusicModel> musics;

    public ArtistModel() {
    }

    public ArtistModel(UUID id, String name, List<MusicModel> musicas) {
        this.id = id;
        this.name = name;
        this.musics = musicas;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<MusicModel> getMusics() {
        return musics;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMusics(List<MusicModel> musics) {
        this.musics = musics;
    }
}
