package com.ciandt.summit.playlist.dto.response;


import com.ciandt.summit.playlist.PlaylistModel;

import java.util.List;
import java.util.UUID;

public class PlaylistResponseDto {

    private final UUID id;
    private final List<MusicDtoResponse> musics;

    public PlaylistResponseDto(PlaylistModel playlistModel) {
        this.id = playlistModel.getId();
        this.musics = playlistModel.getMusics().stream().map(musicModel -> new MusicDtoResponse(musicModel)).toList();
    }

    public UUID getId() {
        return id;
    }

    public List<MusicDtoResponse> getMusics() {
        return musics;
    }


}
