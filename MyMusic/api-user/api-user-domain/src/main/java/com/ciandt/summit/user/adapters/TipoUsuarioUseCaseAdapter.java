package com.ciandt.summit.user.adapters;

import com.ciandt.summit.user.TipoUsuarioModel;
import com.ciandt.summit.user.port.in.TipoUsuarioUseCasePort;
import com.ciandt.summit.user.port.out.TipoUsuarioRepositoryPort;

import java.util.UUID;

public class TipoUsuarioUseCaseAdapter implements TipoUsuarioUseCasePort {

    private final TipoUsuarioRepositoryPort tipoUsuarioRepositoryPort;

    public TipoUsuarioUseCaseAdapter(TipoUsuarioRepositoryPort tipoUsuarioRepositoryPort) {

        this.tipoUsuarioRepositoryPort = tipoUsuarioRepositoryPort;
    }

    @Override
    public TipoUsuarioModel findTipoUsuarioById(UUID id) {

        return tipoUsuarioRepositoryPort.findTipoUsuarioById(id);
    }


}
