package com.ciandt.summit.music.ports.in;

import com.ciandt.summit.music.MusicModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface MusicUseCasePort {

    Page<MusicModel> findMusicsByFilterOrdered(String filter, Pageable pageable);

    MusicModel findMusicByUUID(UUID idMusic);

}
