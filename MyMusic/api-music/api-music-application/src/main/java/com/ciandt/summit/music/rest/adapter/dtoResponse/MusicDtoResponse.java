package com.ciandt.summit.music.rest.adapter.dtoResponse;

import com.ciandt.summit.music.MusicModel;

import java.util.UUID;

public class MusicDtoResponse {

    private UUID id;
    private String name;
    private ArtistDtoResponse artist;

    public MusicDtoResponse() {
    }

    public MusicDtoResponse(UUID id,  String name, ArtistDtoResponse artist) {
        this.id = id;
        this.name = name;
        this.artist = artist;
    }

    public MusicDtoResponse(MusicModel musicModel) {
        this.id = musicModel.getId();
        this.name = musicModel.getName();
        this.artist = new ArtistDtoResponse(musicModel.getArtist());
    }

    public String getName() {
        return name;
    }

    public ArtistDtoResponse getArtist() {
        return artist;
    }

    public MusicDtoResponse toDtoMusic(MusicModel musicModel){
        return new MusicDtoResponse(musicModel);
    }

    public UUID getId() {
        return id;
    }
}
