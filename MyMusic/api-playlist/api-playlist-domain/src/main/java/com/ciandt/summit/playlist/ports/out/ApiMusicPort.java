package com.ciandt.summit.playlist.ports.out;

import com.ciandt.summit.playlist.MusicModel;

import java.util.Optional;
import java.util.UUID;

public interface ApiMusicPort {

    Optional<MusicModel> findMusicById(UUID idMusic);

}
