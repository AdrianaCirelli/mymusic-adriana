package com.ciandt.summit.playlist.adapter.mapper;


import com.ciandt.summit.playlist.MusicModel;
import com.ciandt.summit.playlist.PlaylistModel;
import com.ciandt.summit.playlist.adapter.entity.MusicEntity;
import com.ciandt.summit.playlist.adapter.entity.PlayListEntity;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Mapper(componentModel = "spring")
public abstract class PlaylistMapper {

    public static final PlaylistMapper INSTANCE = Mappers.getMapper(PlaylistMapper.class);

    public abstract PlayListEntity convertToPlaylistEntity(PlaylistModel playlistModel);

    @Mapping(source = "musics", target = "musics")
    public abstract PlaylistModel convertToPlaylistModel(PlayListEntity playListEntity);

    public abstract MusicEntity map(MusicModel value);

    @Mapping(source = "playListEntity", target = "playlist", ignore = true)
    public abstract MusicModel map(MusicEntity value);
}
