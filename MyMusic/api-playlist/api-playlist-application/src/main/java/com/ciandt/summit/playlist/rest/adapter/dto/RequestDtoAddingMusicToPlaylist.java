package com.ciandt.summit.playlist.rest.adapter.dto;

import java.util.UUID;

public class RequestDtoAddingMusicToPlaylist {


    private final UUID idPlaylist;

    private final UUID idMusic;


    public RequestDtoAddingMusicToPlaylist(UUID idPlaylist, UUID idMusic) {
        this.idPlaylist = idPlaylist;
        this.idMusic = idMusic;
    }

    public UUID getIdPlaylist() {
        return idPlaylist;
    }

    public UUID getIdMusic() {
        return idMusic;
    }
}
