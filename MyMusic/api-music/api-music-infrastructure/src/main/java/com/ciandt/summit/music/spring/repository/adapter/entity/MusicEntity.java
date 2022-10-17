package com.ciandt.summit.music.spring.repository.adapter.entity;


import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Musicas")
public class MusicEntity {

    @Id
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name ="Nome")
    private String name;

    @ManyToOne
    @JoinColumn(name ="ArtistaId")
    private ArtistEntity artist;

    public MusicEntity() {
    }

    public MusicEntity(UUID id, String name,  ArtistEntity artist) {
        this.id = id;
        this.name = name;
        this.artist = artist;
    }
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArtistEntity getArtist() {
        return artist;
    }

}
