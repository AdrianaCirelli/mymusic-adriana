package com.ciandt.summit.user.port.out;


import com.ciandt.summit.user.PlaylistModel;
import com.ciandt.summit.user.UserModel;
import com.ciandt.summit.user.port.in.ManipulatingMusicInPlaylistDTO;

public interface ApiPlaylistPort {

    PlaylistModel getPlaylistByUser(UserModel user);

    PlaylistModel removeMusic(ManipulatingMusicInPlaylistDTO dto);

    PlaylistModel addMusic(ManipulatingMusicInPlaylistDTO dto);
}
