package com.ciandt.summit.playlist.adapter.mapper;

import com.ciandt.summit.playlist.ArtistModel;
import com.ciandt.summit.playlist.MusicModel;
import com.ciandt.summit.playlist.adapter.entity.ArtistEntity;
import com.ciandt.summit.playlist.adapter.entity.MusicEntity;
import com.ciandt.summit.playlist.dto.response.ArtistDtoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class ArtistMapper {

    public static final ArtistMapper INSTANCE = Mappers.getMapper(ArtistMapper.class);

    public abstract ArtistEntity convertToArtistEntity(ArtistModel artist);
    public abstract ArtistModel convertToArtistModelFromDto(ArtistDtoResponse artist);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    public abstract ArtistModel convertToArtistModel(ArtistEntity artist);

    public abstract MusicEntity map(MusicModel value);

}
