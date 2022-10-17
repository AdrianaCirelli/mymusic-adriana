package com.ciandt.summit.user.rest.adapter.dto.response;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
