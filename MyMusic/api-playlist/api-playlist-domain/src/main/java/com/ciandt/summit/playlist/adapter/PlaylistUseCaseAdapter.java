package com.ciandt.summit.playlist.adapter;


import com.ciandt.summit.playlist.MusicModel;
import com.ciandt.summit.playlist.PlaylistModel;
import com.ciandt.summit.playlist.ports.in.AddingMusicToPlaylistDTO;
import com.ciandt.summit.playlist.dto.response.PlaylistResponseDto;
import com.ciandt.summit.playlist.exceptions.MusicNotFoundException;
import com.ciandt.summit.playlist.exceptions.PlaylistNotFoundException;
import com.ciandt.summit.playlist.ports.in.PlaylistUseCasePort;
import com.ciandt.summit.playlist.ports.out.ApiMusicPort;
import com.ciandt.summit.playlist.ports.out.PlaylistRepositoryPort;
import org.apache.log4j.Logger;


import java.util.UUID;

public class PlaylistUseCaseAdapter implements PlaylistUseCasePort {

    private PlaylistRepositoryPort playlistRepositoryPort;

    private ApiMusicPort apiMusicPort;

    static final Logger logger = Logger.getLogger(PlaylistUseCaseAdapter.class);

    public PlaylistUseCaseAdapter(PlaylistRepositoryPort playlistRepositoryPort, ApiMusicPort apiMusicPort){
        this.playlistRepositoryPort = playlistRepositoryPort;
        this.apiMusicPort = apiMusicPort;
    }

    @Override
    public PlaylistResponseDto updatePlaylistByAddingMusic(AddingMusicToPlaylistDTO addingMusicToPlaylistDTO) {

        logger.info("Iniciando operação para adicionar música à playlist.");

        PlaylistModel playlistModel = getPlayListById(addingMusicToPlaylistDTO.getIdPlaylist());
        MusicModel musicModel = findMusicById(addingMusicToPlaylistDTO);

        playlistModel.addMusic(musicModel);
        PlaylistModel playlistModelAtualizada = playlistRepositoryPort.savePlaylist(playlistModel);

        logger.info("Música adicionada à playlist com sucesso.");

        return new PlaylistResponseDto(playlistModelAtualizada);
    }

    @Override
    public PlaylistResponseDto removeMusicToPlaylist(AddingMusicToPlaylistDTO addingMusicToPlaylistDTO) {

        logger.info("Removendo música de playlist.");

        var  playlistModel = getPlayListById(addingMusicToPlaylistDTO.getIdPlaylist());
        var musicToRemove = findMusicById(addingMusicToPlaylistDTO);
        playlistModel.removeMusic(musicToRemove);

        var updatedPlaylist  =  playlistRepositoryPort.savePlaylist(playlistModel);

        logger.info("Música de id " + addingMusicToPlaylistDTO.getIdMusic() + " removida da playlist com sucesso.");

        return new PlaylistResponseDto(updatedPlaylist);

    }


    @Override
    public PlaylistModel getPlayListById(UUID idPlaylist) {

        logger.info("Buscando playlist por id.");

        var playlist = playlistRepositoryPort.findPlaylistById(idPlaylist);

        logger.info("Playlist de id " + idPlaylist + " encontrada com sucesso.");

        return playlist;

    }

    public MusicModel findMusicById(AddingMusicToPlaylistDTO addingMusicToPlaylistDTO) {

        logger.info("Buscando música por id.");

        var music = apiMusicPort
                .findMusicById(addingMusicToPlaylistDTO.getIdMusic())
                .orElseThrow(() -> new MusicNotFoundException("Música não encontrada"));

        logger.info("Música de id " + addingMusicToPlaylistDTO.getIdMusic() + " encontrada com sucesso");

        return music;
    }

}
