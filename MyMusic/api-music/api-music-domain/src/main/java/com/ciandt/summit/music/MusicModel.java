package com.ciandt.summit.music;


import java.util.UUID;

public class MusicModel {

    private UUID id;
    private String name;
    private ArtistModel artist;

    public MusicModel() {
    }

    public MusicModel(UUID id, String name, ArtistModel artist) {
        this.id = id;
        this.artist = artist;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArtistModel getArtist() {
        return artist;
    }

    public void setArtist(ArtistModel artist) {
        this.artist = artist;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
