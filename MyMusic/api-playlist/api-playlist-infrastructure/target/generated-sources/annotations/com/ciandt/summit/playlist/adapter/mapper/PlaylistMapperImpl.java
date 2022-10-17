package com.ciandt.summit.playlist.adapter.mapper;

import com.ciandt.summit.playlist.ArtistModel;
import com.ciandt.summit.playlist.MusicModel;
import com.ciandt.summit.playlist.PlaylistModel;
import com.ciandt.summit.playlist.adapter.entity.ArtistEntity;
import com.ciandt.summit.playlist.adapter.entity.MusicEntity;
import com.ciandt.summit.playlist.adapter.entity.PlayListEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-13T15:13:11-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.4 (Oracle Corporation)"
)
@Component
public class PlaylistMapperImpl extends PlaylistMapper {

    @Override
    public PlayListEntity convertToPlaylistEntity(PlaylistModel playlistModel) {
        if ( playlistModel == null ) {
            return null;
        }

        PlayListEntity playListEntity = new PlayListEntity();

        playListEntity.setId( playlistModel.getId() );
        playListEntity.setMusics( musicModelListToMusicEntityList( playlistModel.getMusics() ) );

        return playListEntity;
    }

    @Override
    public PlaylistModel convertToPlaylistModel(PlayListEntity playListEntity) {
        if ( playListEntity == null ) {
            return null;
        }

        PlaylistModel playlistModel = new PlaylistModel();

        playlistModel.setMusics( musicEntityListToMusicModelList( playListEntity.getMusics() ) );
        playlistModel.setId( playListEntity.getId() );

        return playlistModel;
    }

    @Override
    public MusicEntity map(MusicModel value) {
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
    public MusicModel map(MusicEntity value) {
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
            list1.add( map( musicModel ) );
        }

        return list1;
    }

    protected List<MusicModel> musicEntityListToMusicModelList(List<MusicEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<MusicModel> list1 = new ArrayList<MusicModel>( list.size() );
        for ( MusicEntity musicEntity : list ) {
            list1.add( map( musicEntity ) );
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
