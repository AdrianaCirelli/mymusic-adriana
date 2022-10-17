package com.ciandt.summit.user.rest.consumer;

import com.ciandt.summit.user.TipoUsuarioModel;

import java.util.UUID;

public class TipoUsuarioDtoResponse {

    private UUID id;
    private String descricao;

    public TipoUsuarioDtoResponse() {

    }

    public TipoUsuarioDtoResponse(UUID id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public TipoUsuarioDtoResponse(TipoUsuarioModel tipoUsuarioModel){
        this.id = tipoUsuarioModel.getId();
        this.descricao = tipoUsuarioModel.getDescricao();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
