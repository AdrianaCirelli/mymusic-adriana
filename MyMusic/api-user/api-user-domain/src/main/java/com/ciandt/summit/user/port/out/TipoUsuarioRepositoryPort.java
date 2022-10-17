package com.ciandt.summit.user.port.out;

import com.ciandt.summit.user.TipoUsuarioModel;

import java.util.UUID;

public interface TipoUsuarioRepositoryPort {

    TipoUsuarioModel findTipoUsuarioById(UUID id);
}
