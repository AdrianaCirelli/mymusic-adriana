package com.ciandt.summit.playlist.ports.in;

import java.util.UUID;

public class AddingMusicToPlaylistDTO {

    private final UUID idPlaylist;
    private final UUID idMusic;

    public AddingMusicToPlaylistDTO(UUID idPlaylist, UUID idMusic){
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
