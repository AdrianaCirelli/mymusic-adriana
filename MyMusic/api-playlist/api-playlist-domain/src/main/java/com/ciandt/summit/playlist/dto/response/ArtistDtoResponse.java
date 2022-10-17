package com.ciandt.summit.playlist.dto.response;

import com.ciandt.summit.playlist.ArtistModel;

import java.util.UUID;

public class ArtistDtoResponse {

    private UUID id;

    private String name;

    public ArtistDtoResponse() {
    }

    public ArtistDtoResponse(ArtistModel artist) {
        this.id = artist.getId();
        this.name = artist.getName();
    }


    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
