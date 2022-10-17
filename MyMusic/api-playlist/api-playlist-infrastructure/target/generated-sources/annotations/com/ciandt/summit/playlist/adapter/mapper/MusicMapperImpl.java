package com.ciandt.summit.playlist.adapter.mapper;

import com.ciandt.summit.playlist.ArtistModel;
import com.ciandt.summit.playlist.MusicModel;
import com.ciandt.summit.playlist.adapter.entity.ArtistEntity;
import com.ciandt.summit.playlist.adapter.entity.MusicEntity;
import com.ciandt.summit.playlist.dto.response.ArtistDtoResponse;
import com.ciandt.summit.playlist.rest.consummer.MusicDtoResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-13T15:13:11-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.4 (Oracle Corporation)"
)
@Component
public class MusicMapperImpl extends MusicMapper {

    @Override
    public MusicEntity convertToMusicEntity(MusicModel music) {
        if ( music == null ) {
            return null;
        }

        MusicEntity musicEntity = new MusicEntity();

        musicEntity.setId( music.getId() );
        musicEntity.setName( music.getName() );
        musicEntity.setArtist( artistModelToArtistEntity( music.getArtist() ) );

        return musicEntity;
    }

    @Override
    public MusicModel convertToMusicModelFromDto(MusicDtoResponse musicDtoResponse) {
        if ( musicDtoResponse == null ) {
            return null;
        }

        MusicModel musicModel = new MusicModel();

        musicModel.setId( musicDtoResponse.getId() );
        musicModel.setName( musicDtoResponse.getName() );
        musicModel.setArtist( artistDtoResponseToArtistModel( musicDtoResponse.getArtist() ) );

        return musicModel;
    }

    @Override
    public MusicModel convertToMusicModel(MusicEntity music) {
        if ( music == null ) {
            return null;
        }

        MusicModel musicModel = new MusicModel();

        musicModel.setId( music.getId() );
        musicModel.setName( music.getName() );
        musicModel.setArtist( artistEntityToArtistModel( music.getArtist() ) );

        return musicModel;
    }

    protected ArtistEntity artistModelToArtistEntity(ArtistModel artistModel) {
        if ( artistModel == null ) {
            return null;
        }

        ArtistEntity artistEntity = new ArtistEntity();

        artistEntity.setId( artistModel.getId() );
        artistEntity.setName( artistModel.getName() );

        return artistEntity;
    }

    protected ArtistModel artistDtoResponseToArtistModel(ArtistDtoResponse artistDtoResponse) {
        if ( artistDtoResponse == null ) {
            return null;
        }

        ArtistModel artistModel = new ArtistModel();

        artistModel.setId( artistDtoResponse.getId() );
        artistModel.setName( artistDtoResponse.getName() );

        return artistModel;
    }

    protected ArtistModel artistEntityToArtistModel(ArtistEntity artistEntity) {
        if ( artistEntity == null ) {
            return null;
        }

        ArtistModel artistModel = new ArtistModel();

        artistModel.setId( artistEntity.getId() );
        artistModel.setName( artistEntity.getName() );

        return artistModel;
    }
}
