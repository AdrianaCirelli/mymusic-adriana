package com.ciandt.summit.playlist.rest.consummer;

import com.ciandt.summit.playlist.ArtistModel;
import com.ciandt.summit.playlist.MusicModel;
import com.ciandt.summit.playlist.adapter.mapper.ArtistMapper;
import com.ciandt.summit.playlist.adapter.mapper.MusicMapper;
import com.ciandt.summit.playlist.ports.out.ApiMusicPort;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class ApiMusicAdapter implements ApiMusicPort {

    private final ApiMusicProxy apiMusicProxy;

    public ApiMusicAdapter(ApiMusicProxy apiMusicProxy) {
        this.apiMusicProxy = apiMusicProxy;
    }

    @Override
    public Optional<MusicModel> findMusicById(UUID idMusic) {

        MusicDtoResponse musicDtoResponse;

        try{
            musicDtoResponse = apiMusicProxy.findMusic(idMusic);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return Optional.empty();
        }

        ArtistModel artistModel = ArtistMapper.INSTANCE.convertToArtistModelFromDto(musicDtoResponse.getArtist());
        MusicModel musicModel = MusicMapper.INSTANCE.convertToMusicModelFromDto(musicDtoResponse);

        musicModel.setArtist(artistModel);

        return Optional.of(musicModel);
    }
}
