package com.ciandt.summit.playlist;

import java.util.Objects;
import java.util.UUID;

public class MusicModel {

    private UUID id;

    private String name;

    private ArtistModel artist;

    private PlaylistModel playlist;

    public MusicModel() {
    }

    public MusicModel(UUID id, String name, ArtistModel artist, PlaylistModel playlist) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.playlist = playlist;
    }

    public MusicModel(UUID id, String name, ArtistModel artist) {
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

    public PlaylistModel getPlaylist() {
        return playlist;
    }

    public void setId(UUID id){
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlaylist(PlaylistModel playlist) {
        this.playlist = playlist;
    }

    public ArtistModel getArtist() {
        return artist;
    }

    public void setArtist(ArtistModel artist) {
        this.artist = artist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MusicModel model = (MusicModel) o;
        return Objects.equals(id, model.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
