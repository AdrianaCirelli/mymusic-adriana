package com.ciandt.summit.music.util.mapper;

import com.ciandt.summit.music.ArtistModel;
import com.ciandt.summit.music.MusicModel;
import com.ciandt.summit.music.spring.repository.adapter.entity.ArtistEntity;
import com.ciandt.summit.music.spring.repository.adapter.entity.MusicEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-13T15:13:03-0300",
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

        artistEntity.setName( artist.getName() );
        if ( artistEntity.getMusics() != null ) {
            List<MusicEntity> list = musicModelListToMusicEntityList( artist.getMusics() );
            if ( list != null ) {
                artistEntity.getMusics().addAll( list );
            }
        }

        return artistEntity;
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

        return musicEntity;
    }

    protected List<MusicEntity> musicModelListToMusicEntityList(List<MusicModel> list) {
        if ( list == null ) {
            return null;
        }

        List<MusicEntity> list1 = new ArrayList<MusicEntity>( list.size() );
        for ( MusicModel musicModel : list ) {
            list1.add( map( musicModel ) );
        }

        return list1;
    }
}
