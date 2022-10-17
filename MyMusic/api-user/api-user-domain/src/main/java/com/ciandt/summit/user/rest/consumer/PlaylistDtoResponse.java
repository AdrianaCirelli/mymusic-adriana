package com.ciandt.summit.user.rest.consumer;


import com.ciandt.summit.user.PlaylistModel;

import java.util.List;
import java.util.UUID;

public class PlaylistDtoResponse {

    private UUID id;

    private List<MusicDtoResponse> musics;


    public PlaylistDtoResponse() {
    }

    public PlaylistDtoResponse(UUID id, List<MusicDtoResponse> musics) {
        this.id = id;
        this.musics = musics;
    }

    public PlaylistDtoResponse(PlaylistModel playlistModel) {
        this.id = playlistModel.getId();
        this.musics = playlistModel.getMusics().stream().map(MusicDtoResponse::new).toList();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<MusicDtoResponse> getMusics() {
        return musics;
    }

    public void setMusics(List<MusicDtoResponse> musics) {
        this.musics = musics;
    }

}
