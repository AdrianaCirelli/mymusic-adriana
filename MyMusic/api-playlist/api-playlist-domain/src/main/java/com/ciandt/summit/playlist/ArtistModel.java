package com.ciandt.summit.playlist;

import java.util.UUID;

public class ArtistModel {

    private UUID id;

    private String name;

    public ArtistModel() {
    }

    public ArtistModel(UUID id, String name) {
        this.id = id;
        this.name = name;
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
}
