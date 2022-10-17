package com.ciandt.summit.user.mapper;


import com.ciandt.summit.user.MusicModel;
import com.ciandt.summit.user.rest.consumer.MusicDtoResponse;
import com.ciandt.summit.user.spring.repository.adapters.entity.MusicEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class MusicMapper {

    public static final MusicMapper INSTANCE = Mappers.getMapper(MusicMapper.class);

    public abstract MusicEntity convertToMusicEntity(MusicModel music);

    public abstract MusicModel convertToMusicModelFromDto(MusicDtoResponse musicDtoResponse);

    public abstract MusicModel convertToMusicModel(MusicEntity music);

}
