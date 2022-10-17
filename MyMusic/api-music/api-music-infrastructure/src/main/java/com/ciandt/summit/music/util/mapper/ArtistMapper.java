package com.ciandt.summit.music.util.mapper;

import com.ciandt.summit.music.ArtistModel;
import com.ciandt.summit.music.MusicModel;
import com.ciandt.summit.music.spring.repository.adapter.entity.ArtistEntity;
import com.ciandt.summit.music.spring.repository.adapter.entity.MusicEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class ArtistMapper {

    public static final ArtistMapper INSTANCE = Mappers.getMapper(ArtistMapper.class);

    public abstract ArtistEntity convertToArtistEntity(ArtistModel artist);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "musics", target = "musics", ignore = true)
    public abstract ArtistModel convertToArtistModel(ArtistEntity artist);

    public abstract MusicEntity map(MusicModel value);

}
