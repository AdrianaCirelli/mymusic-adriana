package com.ciandt.summit.user.spring.repository.adapters;

import com.ciandt.summit.user.TipoUsuarioModel;
import com.ciandt.summit.user.exception.security.TipoUserNotFoundException;
import com.ciandt.summit.user.mapper.TipoUsuarioMapper;
import com.ciandt.summit.user.port.in.TipoUsuarioUseCasePort;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoUsuarioRepositoryAdapter implements TipoUsuarioUseCasePort {

    private final TipoUsuarioRepository tipoUsuarioRepository;

    public TipoUsuarioRepositoryAdapter(TipoUsuarioRepository tipoUsuarioRepository) {
        this.tipoUsuarioRepository = tipoUsuarioRepository;
    }

    @Override
    public TipoUsuarioModel findTipoUsuarioById(UUID id) {

        var tipoUsuarioEntity = tipoUsuarioRepository.findById(id).orElseThrow(()-> {

            return new TipoUserNotFoundException("Tipo Usuário nao encontrado.");
        });

        return TipoUsuarioMapper.INSTANCE.convertToTipoUsuarioModel(tipoUsuarioEntity);
    }
}
