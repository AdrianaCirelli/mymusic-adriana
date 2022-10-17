package com.ciandt.summit.music.spring.repository.adapter;

import com.ciandt.summit.music.spring.repository.adapter.entity.MusicEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MusicRepository extends JpaRepository<MusicEntity, UUID> {

    @Query("SELECT m FROM MusicEntity m JOIN m.artist a " +
            "WHERE lower(m.name) like %:filter% " +
            "OR lower(a.name) like %:filter% ")
    Page<MusicEntity> findMusicsByFilter(@Param("filter") String filter, Pageable pageable);

}
