package com.ciandt.summit.user;



import java.util.UUID;

public class MusicModel {

    private UUID id;
    private String name;

    private ArtistModel artist;

    private PlaylistModel playlist;


    public MusicModel() {
    }


    public MusicModel(UUID id, String name, ArtistModel artist) {
        this.id = id;
        this.name = name;
        this.artist = artist;
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

    public ArtistModel getArtist() {
        return artist;
    }

    public void setArtist(ArtistModel artist) {
        this.artist = artist;
    }

    public PlaylistModel getPlaylist() {
        return playlist;
    }

    public void setPlaylist(PlaylistModel playlist) {
        this.playlist = playlist;
    }
}
