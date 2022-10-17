package com.ciandt.summit.user.mapper;

import com.ciandt.summit.user.ArtistModel;
import com.ciandt.summit.user.MusicModel;
import com.ciandt.summit.user.rest.consumer.ArtistDtoResponse;
import com.ciandt.summit.user.spring.repository.adapters.entity.ArtistEntity;
import com.ciandt.summit.user.spring.repository.adapters.entity.MusicEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-14T16:00:43-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.4 (Oracle Corporation)"
)
@Component
public class ArtistMapperImpl extends ArtistMapper {

    @Override
    public ArtistEntity convertToArtistEntity(ArtistModel artist) {
        if ( artist == null ) {
            return null;
        }

        ArtistEntity artistEntity = new ArtistEntity();

        artistEntity.setId( artist.getId() );
        artistEntity.setName( artist.getName() );

        return artistEntity;
    }

    @Override
    public ArtistModel convertToArtistModelFromDto(ArtistDtoResponse artist) {
        if ( artist == null ) {
            return null;
        }

        ArtistModel artistModel = new ArtistModel();

        artistModel.setId( artist.getId() );
        artistModel.setName( artist.getName() );

        return artistModel;
    }

    @Override
    public ArtistModel convertToArtistModel(ArtistEntity artist) {
        if ( artist == null ) {
            return null;
        }

        ArtistModel artistModel = new ArtistModel();

        artistModel.setId( artist.getId() );
        artistModel.setName( artist.getName() );

        return artistModel;
    }

    @Override
    public MusicEntity map(MusicModel value) {
        if ( value == null ) {
            return null;
        }

        MusicEntity musicEntity = new MusicEntity();

        musicEntity.setId( value.getId() );
        musicEntity.setName( value.getName() );
        musicEntity.setArtist( convertToArtistEntity( value.getArtist() ) );

        return musicEntity;
    }
}
