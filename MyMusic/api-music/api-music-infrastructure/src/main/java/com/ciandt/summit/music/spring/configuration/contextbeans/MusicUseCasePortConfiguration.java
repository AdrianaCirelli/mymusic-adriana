package com.ciandt.summit.music.spring.configuration.contextbeans;

import com.ciandt.summit.music.adapters.MusicUseCaseAdapter;
import com.ciandt.summit.music.ports.in.MusicUseCasePort;
import com.ciandt.summit.music.ports.out.MusicRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MusicUseCasePortConfiguration {

    @Bean
    MusicUseCasePort musicUseCasePort(MusicRepositoryPort musicRepositoryPort){
        return new MusicUseCaseAdapter(musicRepositoryPort);
    }
}
