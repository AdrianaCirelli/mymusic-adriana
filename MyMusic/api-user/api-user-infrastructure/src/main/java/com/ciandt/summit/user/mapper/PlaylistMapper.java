package com.ciandt.summit.user.mapper;


import com.ciandt.summit.user.MusicModel;
import com.ciandt.summit.user.PlaylistModel;
import com.ciandt.summit.user.rest.consumer.MusicDtoResponse;
import com.ciandt.summit.user.spring.repository.adapters.entity.MusicEntity;
import com.ciandt.summit.user.spring.repository.adapters.entity.PlaylistEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class PlaylistMapper {

    public static final PlaylistMapper INSTANCE = Mappers.getMapper(PlaylistMapper.class);

    public abstract PlaylistEntity convertToPlaylistEntity(PlaylistModel playlistModel);

    public abstract PlaylistModel convertToPlaylistModel(PlaylistEntity playlistEntity);

    public abstract MusicEntity mapToEntity(MusicModel value);

    public abstract MusicModel mapToModel(MusicEntity value);

}
