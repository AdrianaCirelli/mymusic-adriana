package com.ciandt.summit.playlist.rest.consummer;

import com.ciandt.summit.playlist.dto.response.ArtistDtoResponse;

import java.util.UUID;

public class MusicDtoResponse {

    private UUID id;
    private String name;
    private ArtistDtoResponse artist;

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
