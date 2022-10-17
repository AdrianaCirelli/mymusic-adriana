package com.ciandt.summit.user.spring.repository.adapters;

import com.ciandt.summit.user.spring.repository.adapters.entity.TipoUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuarioEntity,UUID> {

}
