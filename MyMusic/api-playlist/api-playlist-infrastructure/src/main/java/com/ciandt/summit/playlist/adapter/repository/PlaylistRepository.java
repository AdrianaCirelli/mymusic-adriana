package com.ciandt.summit.playlist.adapter.repository;

import com.ciandt.summit.playlist.adapter.entity.MusicEntity;
import com.ciandt.summit.playlist.adapter.entity.PlayListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlaylistRepository extends JpaRepository<PlayListEntity, UUID> {

}
