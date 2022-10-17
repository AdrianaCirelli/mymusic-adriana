package com.ciandt.summit.user.mapper;

import com.ciandt.summit.user.TipoUsuarioModel;
import com.ciandt.summit.user.spring.repository.adapters.entity.TipoUsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class TipoUsuarioMapper {

    public static final TipoUsuarioMapper INSTANCE = Mappers.getMapper(TipoUsuarioMapper.class);

    public abstract TipoUsuarioEntity convertToTipoUsuarioEntity(TipoUsuarioModel tipoUsuario);

    public abstract TipoUsuarioModel convertToTipoUsuarioModel(TipoUsuarioEntity tipoUsuario);

}
