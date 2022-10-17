package com.ciandt.summit.playlist.ports.out;


import com.ciandt.summit.playlist.PlaylistModel;

import java.util.UUID;

public interface PlaylistRepositoryPort {

    PlaylistModel findPlaylistById(UUID idPlayList);

    PlaylistModel savePlaylist(PlaylistModel playlistModel);


}
