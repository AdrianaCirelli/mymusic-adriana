package com.ciandt.summit.user.rest.adapter.dto.request;

import java.util.UUID;

public class RequestDtoManipulateMusicInPlaylist {


    private final UUID idPlaylist;

    private final UUID idMusic;


    public RequestDtoManipulateMusicInPlaylist(UUID idPlaylist, UUID idMusic) {
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
