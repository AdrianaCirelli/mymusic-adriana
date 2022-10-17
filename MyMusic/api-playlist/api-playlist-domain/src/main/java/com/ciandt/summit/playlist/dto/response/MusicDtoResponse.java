package com.ciandt.summit.playlist.dto.response;

import com.ciandt.summit.playlist.MusicModel;

import java.util.UUID;

public class MusicDtoResponse {

    private final UUID id;

    private final String name;

    private final ArtistDtoResponse artist;

    public MusicDtoResponse(MusicModel musicModel) {
        this.id = musicModel.getId();
        this.name = musicModel.getName();
        this.artist = new ArtistDtoResponse(musicModel.getArtist());
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArtistDtoResponse getArtist() {
        return artist;
    }
}
