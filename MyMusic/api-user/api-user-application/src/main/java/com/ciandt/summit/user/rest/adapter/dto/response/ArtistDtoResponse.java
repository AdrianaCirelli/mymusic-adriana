package com.ciandt.summit.user.rest.adapter.dto.response;

import com.ciandt.summit.user.ArtistModel;

import java.util.UUID;

public class ArtistDtoResponse {

    private UUID id;
    private String name;

    public ArtistDtoResponse() {

    }

    public ArtistDtoResponse(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public ArtistDtoResponse(ArtistModel artistModel) {
        this.id = artistModel.getId();
        this.name = artistModel.getName();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArtistDtoResponse toDtoArtist(ArtistModel artistModel) {
        return new ArtistDtoResponse(artistModel.getId(), artistModel.getName());

    }


}
