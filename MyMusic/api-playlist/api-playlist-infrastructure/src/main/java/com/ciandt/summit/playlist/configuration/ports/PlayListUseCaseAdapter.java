package com.ciandt.summit.playlist.configuration.ports;

import com.ciandt.summit.playlist.adapter.PlaylistUseCaseAdapter;
import com.ciandt.summit.playlist.ports.in.PlaylistUseCasePort;
import com.ciandt.summit.playlist.ports.out.ApiMusicPort;
import com.ciandt.summit.playlist.ports.out.PlaylistRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlayListUseCaseAdapter {

    @Bean
    PlaylistUseCasePort playlistUseCasePort(PlaylistRepositoryPort repositoryPort, ApiMusicPort apiMusicPort){
        return new PlaylistUseCaseAdapter(repositoryPort, apiMusicPort);
    }

}
