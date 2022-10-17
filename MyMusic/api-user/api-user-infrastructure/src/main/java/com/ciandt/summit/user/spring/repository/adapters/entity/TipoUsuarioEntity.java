package com.ciandt.summit.user.spring.repository.adapters.entity;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "TipoUsuario")
public class TipoUsuarioEntity {

    @Id
    @Type(type = "uuid-char")
    @Column(name = "Id")
    private UUID id;

    @Column(name = "Descricao")
    private String descricao;

    public TipoUsuarioEntity() {

    }

    public TipoUsuarioEntity(UUID id, String descricao) {
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
