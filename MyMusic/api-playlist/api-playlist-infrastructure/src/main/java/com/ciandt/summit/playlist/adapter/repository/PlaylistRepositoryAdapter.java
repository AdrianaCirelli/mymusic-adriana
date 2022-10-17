package com.ciandt.summit.playlist.adapter.repository;


import com.ciandt.summit.playlist.PlaylistModel;
import com.ciandt.summit.playlist.adapter.entity.PlayListEntity;
import com.ciandt.summit.playlist.adapter.mapper.PlaylistMapper;
import com.ciandt.summit.playlist.exceptions.PlaylistNotFoundException;
import com.ciandt.summit.playlist.ports.out.PlaylistRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;


@Component
public class PlaylistRepositoryAdapter implements PlaylistRepositoryPort {

    public final PlaylistRepository playlistRepository;

    public PlaylistRepositoryAdapter(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    @Override
    public PlaylistModel findPlaylistById(UUID idPlayList) {

        var playListEntity = playlistRepository.findById(idPlayList).orElseThrow(() ->
                new PlaylistNotFoundException("Playlist Não encontrada")
        );

        return PlaylistMapper.INSTANCE.convertToPlaylistModel(playListEntity);

    }

    @Override
    public PlaylistModel savePlaylist(PlaylistModel playlistModel) {
        PlayListEntity playListEntity = PlaylistMapper.INSTANCE.convertToPlaylistEntity(playlistModel);
        var playListEntitySaved = playlistRepository.save(playListEntity);
        return PlaylistMapper.INSTANCE.convertToPlaylistModel(playListEntitySaved);
    }


}
