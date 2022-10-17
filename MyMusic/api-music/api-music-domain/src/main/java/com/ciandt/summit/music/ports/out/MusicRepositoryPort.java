package com.ciandt.summit.music.ports.out;

import com.ciandt.summit.music.MusicModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface MusicRepositoryPort {

    Page<MusicModel> findMusicAndArtistByFilter(String filter, Pageable pageable);

    MusicModel findMusicById(UUID idMusic);
}