package com.ciandt.summit.user.mapper;


import com.ciandt.summit.user.ArtistModel;
import com.ciandt.summit.user.MusicModel;
import com.ciandt.summit.user.rest.consumer.ArtistDtoResponse;
import com.ciandt.summit.user.spring.repository.adapters.entity.ArtistEntity;
import com.ciandt.summit.user.spring.repository.adapters.entity.MusicEntity;
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
