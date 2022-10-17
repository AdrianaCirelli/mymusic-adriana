package com.ciandt.summit.user.mapper;

import com.ciandt.summit.user.ArtistModel;
import com.ciandt.summit.user.MusicModel;
import com.ciandt.summit.user.PlaylistModel;
import com.ciandt.summit.user.UserModel;
import com.ciandt.summit.user.rest.consumer.ArtistDtoResponse;
import com.ciandt.summit.user.rest.consumer.MusicDtoResponse;
import com.ciandt.summit.user.rest.consumer.PlaylistDtoResponse;
import com.ciandt.summit.user.rest.consumer.UserDtoResponse;
import com.ciandt.summit.user.spring.repository.adapters.entity.ArtistEntity;
import com.ciandt.summit.user.spring.repository.adapters.entity.MusicEntity;
import com.ciandt.summit.user.spring.repository.adapters.entity.PlaylistEntity;
import com.ciandt.summit.user.spring.repository.adapters.entity.UserEntity;
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
public class UserMapperImpl extends UserMapper {

    @Override
    public UserEntity convertToUserEntity(UserModel user) {
        if ( user == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( user.getId() );
        userEntity.setName( user.getName() );
        userEntity.setPlaylist( playlistModelToPlaylistEntity( user.getPlaylist() ) );

        return userEntity;
    }

    @Override
    public UserModel convertToUserModel(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setName( userEntity.getName() );
        userModel.setId( userEntity.getId() );
        userModel.setPlaylist( playlistEntityToPlaylistModel( userEntity.getPlaylist() ) );

        return userModel;
    }

    @Override
    public UserDtoResponse converToUserDtoResponse(UserModel userModel) {
        if ( userModel == null ) {
            return null;
        }

        UserDtoResponse userDtoResponse = new UserDtoResponse();

        userDtoResponse.setId( userModel.getId() );
        userDtoResponse.setName( userModel.getName() );
        userDtoResponse.setPlaylist( playlistModelToPlaylistDtoResponse( userModel.getPlaylist() ) );

        return userDtoResponse;
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

    protected MusicEntity musicModelToMusicEntity(MusicModel musicModel) {
        if ( musicModel == null ) {
            return null;
        }

        MusicEntity musicEntity = new MusicEntity();

        musicEntity.setId( musicModel.getId() );
        musicEntity.setName( musicModel.getName() );
        musicEntity.setArtist( artistModelToArtistEntity( musicModel.getArtist() ) );

        return musicEntity;
    }

    protected List<MusicEntity> musicModelListToMusicEntityList(List<MusicModel> list) {
        if ( list == null ) {
            return null;
        }

        List<MusicEntity> list1 = new ArrayList<MusicEntity>( list.size() );
        for ( MusicModel musicModel : list ) {
            list1.add( musicModelToMusicEntity( musicModel ) );
        }

        return list1;
    }

    protected PlaylistEntity playlistModelToPlaylistEntity(PlaylistModel playlistModel) {
        if ( playlistModel == null ) {
            return null;
        }

        PlaylistEntity playlistEntity = new PlaylistEntity();

        playlistEntity.setId( playlistModel.getId() );
        playlistEntity.setMusics( musicModelListToMusicEntityList( playlistModel.getMusics() ) );

        return playlistEntity;
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

    protected MusicModel musicEntityToMusicModel(MusicEntity musicEntity) {
        if ( musicEntity == null ) {
            return null;
        }

        MusicModel musicModel = new MusicModel();

        musicModel.setId( musicEntity.getId() );
        musicModel.setName( musicEntity.getName() );
        musicModel.setArtist( artistEntityToArtistModel( musicEntity.getArtist() ) );

        return musicModel;
    }

    protected List<MusicModel> musicEntityListToMusicModelList(List<MusicEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<MusicModel> list1 = new ArrayList<MusicModel>( list.size() );
        for ( MusicEntity musicEntity : list ) {
            list1.add( musicEntityToMusicModel( musicEntity ) );
        }

        return list1;
    }

    protected PlaylistModel playlistEntityToPlaylistModel(PlaylistEntity playlistEntity) {
        if ( playlistEntity == null ) {
            return null;
        }

        PlaylistModel playlistModel = new PlaylistModel();

        playlistModel.setId( playlistEntity.getId() );
        playlistModel.setMusics( musicEntityListToMusicModelList( playlistEntity.getMusics() ) );

        return playlistModel;
    }

    protected ArtistDtoResponse artistModelToArtistDtoResponse(ArtistModel artistModel) {
        if ( artistModel == null ) {
            return null;
        }

        ArtistDtoResponse artistDtoResponse = new ArtistDtoResponse();

        return artistDtoResponse;
    }

    protected MusicDtoResponse musicModelToMusicDtoResponse(MusicModel musicModel) {
        if ( musicModel == null ) {
            return null;
        }

        MusicDtoResponse musicDtoResponse = new MusicDtoResponse();

        musicDtoResponse.setId( musicModel.getId() );
        musicDtoResponse.setName( musicModel.getName() );
        musicDtoResponse.setArtist( artistModelToArtistDtoResponse( musicModel.getArtist() ) );

        return musicDtoResponse;
    }

    protected List<MusicDtoResponse> musicModelListToMusicDtoResponseList(List<MusicModel> list) {
        if ( list == null ) {
            return null;
        }

        List<MusicDtoResponse> list1 = new ArrayList<MusicDtoResponse>( list.size() );
        for ( MusicModel musicModel : list ) {
            list1.add( musicModelToMusicDtoResponse( musicModel ) );
        }

        return list1;
    }

    protected PlaylistDtoResponse playlistModelToPlaylistDtoResponse(PlaylistModel playlistModel) {
        if ( playlistModel == null ) {
            return null;
        }

        PlaylistDtoResponse playlistDtoResponse = new PlaylistDtoResponse();

        playlistDtoResponse.setId( playlistModel.getId() );
        playlistDtoResponse.setMusics( musicModelListToMusicDtoResponseList( playlistModel.getMusics() ) );

        return playlistDtoResponse;
    }
}
