package com.ciandt.summit.user;

import java.util.UUID;

public class TipoUsuarioModel {

    private UUID id;
    private String descricao;

    public TipoUsuarioModel() {

    }

    public TipoUsuarioModel(UUID id, String descricao) {
        this.id = id;
        this.descricao = descricao;
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
