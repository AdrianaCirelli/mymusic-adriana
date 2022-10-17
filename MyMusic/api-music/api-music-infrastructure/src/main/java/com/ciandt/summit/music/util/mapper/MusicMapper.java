package com.ciandt.summit.music.util.mapper;

import com.ciandt.summit.music.MusicModel;
import com.ciandt.summit.music.spring.repository.adapter.entity.MusicEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class MusicMapper {

    public static final MusicMapper INSTANCE = Mappers.getMapper(MusicMapper.class);

    public abstract MusicEntity convertToMusicEntity(MusicModel music);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "artist", target = "artist", ignore = true)
    public abstract MusicModel convertToMusicModel(MusicEntity music);

}
