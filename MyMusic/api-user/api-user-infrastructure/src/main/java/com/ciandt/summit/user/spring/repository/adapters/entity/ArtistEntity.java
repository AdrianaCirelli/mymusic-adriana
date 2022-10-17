package com.ciandt.summit.user.spring.repository.adapters.entity;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
