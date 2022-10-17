package com.ciandt.summit.user.mapper;

import com.ciandt.summit.user.ArtistModel;
import com.ciandt.summit.user.MusicModel;
import com.ciandt.summit.user.PlaylistModel;
import com.ciandt.summit.user.spring.repository.adapters.entity.ArtistEntity;
import com.ciandt.summit.user.spring.repository.adapters.entity.MusicEntity;
import com.ciandt.summit.user.spring.repository.adapters.entity.PlaylistEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-14T16:00:44-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.4 (Oracle Corporation)"
)
@Component
public class PlaylistMapperImpl extends PlaylistMapper {

    @Override
    public PlaylistEntity convertToPlaylistEntity(PlaylistModel playlistModel) {
        if ( playlistModel == null ) {
            return null;
        }

        PlaylistEntity playlistEntity = new PlaylistEntity();

        playlistEntity.setId( playlistModel.getId() );
        playlistEntity.setMusics( musicModelListToMusicEntityList( playlistModel.getMusics() ) );

        return playlistEntity;
    }

    @Override
    public PlaylistModel convertToPlaylistModel(PlaylistEntity playlistEntity) {
        if ( playlistEntity == null ) {
            return null;
        }

        PlaylistModel playlistModel = new PlaylistModel();

        playlistModel.setId( playlistEntity.getId() );
        playlistModel.setMusics( musicEntityListToMusicModelList( playlistEntity.getMusics() ) );

        return playlistModel;
    }

    @Override
    public MusicEntity mapToEntity(MusicModel value) {
        if ( value == null ) {
            return null;
        }

        MusicEntity musicEntity = new MusicEntity();

        musicEntity.setId( value.getId() );
        musicEntity.setName( value.getName() );
        musicEntity.setArtist( artistModelToArtistEntity( value.getArtist() ) );

        return musicEntity;
    }

    @Override
    public MusicModel mapToModel(MusicEntity value) {
        if ( value == null ) {
            return null;
        }

        MusicModel musicModel = new MusicModel();

        musicModel.setId( value.getId() );
        musicModel.setName( value.getName() );
        musicModel.setArtist( artistEntityToArtistModel( value.getArtist() ) );

        return musicModel;
    }

    protected List<MusicEntity> musicModelListToMusicEntityList(List<MusicModel> list) {
        if ( list == null ) {
            return null;
        }

        List<MusicEntity> list1 = new ArrayList<MusicEntity>( list.size() );
        for ( MusicModel musicModel : list ) {
            list1.add( mapToEntity( musicModel ) );
        }

        return list1;
    }

    protected List<MusicModel> musicEntityListToMusicModelList(List<MusicEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<MusicModel> list1 = new ArrayList<MusicModel>( list.size() );
        for ( MusicEntity musicEntity : list ) {
            list1.add( mapToModel( musicEntity ) );
        }

        return list1;
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
