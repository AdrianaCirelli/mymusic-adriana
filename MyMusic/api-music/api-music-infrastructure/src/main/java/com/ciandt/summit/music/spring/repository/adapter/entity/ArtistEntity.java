package com.ciandt.summit.music.spring.repository.adapter.entity;


import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table (name = "Artistas")
public class ArtistEntity {

    @Id
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name ="Nome")
    private String name;

    @OneToMany(mappedBy = "artist", fetch = FetchType.LAZY)
    private List<MusicEntity> musics;

    public ArtistEntity() {
    }

    public ArtistEntity(UUID id, String name, List<MusicEntity> musics) {
        this.id = id;
        this.name = name;
        this.musics = musics;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<MusicEntity> getMusics() {
        return musics;
    }

    public void setName(String name) {
        this.name = name;
    }
}
