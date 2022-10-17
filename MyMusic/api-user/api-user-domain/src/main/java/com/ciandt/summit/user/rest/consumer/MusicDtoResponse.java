package com.ciandt.summit.user.rest.consumer;


import com.ciandt.summit.user.MusicModel;

import java.util.UUID;

public class MusicDtoResponse {

    private UUID id;
    private String name;
    private ArtistDtoResponse artist;

    public MusicDtoResponse(){

    }

    public MusicDtoResponse(UUID id, String name, ArtistDtoResponse artist) {
        this.id = id;
        this.name = name;
        this.artist = artist;
    }

    public MusicDtoResponse(MusicModel musicModel) {
        this.id = musicModel.getId();
        this.name = musicModel.getName();
        this.artist = new ArtistDtoResponse(musicModel.getArtist());
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

    public ArtistDtoResponse getArtist() {
        return artist;
    }

    public void setArtist(ArtistDtoResponse artist) {
        this.artist = artist;
    }
}
