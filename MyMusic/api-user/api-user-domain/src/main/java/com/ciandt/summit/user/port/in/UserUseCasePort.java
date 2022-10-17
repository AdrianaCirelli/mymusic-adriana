package com.ciandt.summit.user.port.in;

import com.ciandt.summit.user.PlaylistModel;
import com.ciandt.summit.user.UserModel;

import java.util.UUID;

public interface UserUseCasePort {

   UserModel findUserByUUID(UUID idUser);

   UserModel findUserByName(String name);

   PlaylistModel getUserPlaylist(UUID idUser);

   PlaylistModel removeMusic(UUID idUser, ManipulatingMusicInPlaylistDTO removeMusicDto);

   PlaylistModel addMusicToPlaylist(UUID uuid, ManipulatingMusicInPlaylistDTO addMusicDto);

}
