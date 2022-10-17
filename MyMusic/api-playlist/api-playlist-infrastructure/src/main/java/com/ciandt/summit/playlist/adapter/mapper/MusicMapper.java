package com.ciandt.summit.playlist.adapter.mapper;


import com.ciandt.summit.playlist.MusicModel;
import com.ciandt.summit.playlist.adapter.entity.MusicEntity;
import com.ciandt.summit.playlist.rest.consummer.MusicDtoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class MusicMapper {

    public static final MusicMapper INSTANCE = Mappers.getMapper(MusicMapper.class);

    public abstract MusicEntity convertToMusicEntity(MusicModel music);

    public abstract MusicModel convertToMusicModelFromDto(MusicDtoResponse musicDtoResponse);

    @Mapping(source = "id", target = "id")
    public abstract MusicModel convertToMusicModel(MusicEntity music);

}
