package com.ciandt.summit.playlist.adapter.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Artistas")
public class ArtistEntity {

    @Id
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "Nome")
    private String name;

    public ArtistEntity() {
    }

    public ArtistEntity(UUID id, String name) {
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
