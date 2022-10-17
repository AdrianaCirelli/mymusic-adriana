package com.ciandt.summit.playlist.ports.in;

import com.ciandt.summit.playlist.PlaylistModel;
import com.ciandt.summit.playlist.dto.response.PlaylistResponseDto;

import java.util.UUID;

public interface PlaylistUseCasePort {

    PlaylistModel getPlayListById(UUID idPlaylist);

    PlaylistResponseDto updatePlaylistByAddingMusic(AddingMusicToPlaylistDTO addingMusicToPlaylistDTO);

    PlaylistResponseDto removeMusicToPlaylist (AddingMusicToPlaylistDTO addingMusicToPlaylistDTO);

}
