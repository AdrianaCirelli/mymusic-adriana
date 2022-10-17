package com.ciandt.summit.user.port.in;

import com.ciandt.summit.user.TipoUsuarioModel;

import java.util.UUID;

public interface TipoUsuarioUseCasePort {

    TipoUsuarioModel findTipoUsuarioById(UUID id);
}
