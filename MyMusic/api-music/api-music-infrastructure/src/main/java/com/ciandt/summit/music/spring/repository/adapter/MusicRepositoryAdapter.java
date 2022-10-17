package com.ciandt.summit.music.spring.repository.adapter;

import com.ciandt.summit.music.MusicModel;
import com.ciandt.summit.music.util.mapper.ArtistMapper;
import com.ciandt.summit.music.util.mapper.MusicMapper;
import com.ciandt.summit.music.spring.repository.exception.MusicNotFoundException;
import com.ciandt.summit.music.ports.out.MusicRepositoryPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
public class MusicRepositoryAdapter implements MusicRepositoryPort {

    private final MusicRepository musicRepository;
    static final Logger logger = Logger.getLogger(MusicRepositoryAdapter.class);

    public MusicRepositoryAdapter(MusicRepository musicRepository){
        this.musicRepository = musicRepository;
    }

    @Override
    public Page<MusicModel> findMusicAndArtistByFilter(String filter, Pageable pageable) {
        String lowerFilter = toLowerCase(filter);

        var pageOfMusicEntity = musicRepository.findMusicsByFilter(lowerFilter, pageable);

        return pageOfMusicEntity.map(musicEntity -> {

            var artistModel = ArtistMapper.INSTANCE.convertToArtistModel(musicEntity.getArtist());

            var musicModel = MusicMapper.INSTANCE.convertToMusicModel(musicEntity);

            musicModel.setArtist(artistModel);

            return musicModel;

        });
    }

    @Override
    public MusicModel findMusicById(UUID idMusic) {
        var musicEntity = musicRepository.findById(idMusic)
                .orElseThrow(() -> {
                    logger.info("Música inexistente no banco de dados.");
                    return new MusicNotFoundException("Música inexistente no banco de dados.");
                });

        var artistModel = ArtistMapper.INSTANCE.convertToArtistModel(musicEntity.getArtist());

        var musicModel = MusicMapper.INSTANCE.convertToMusicModel(musicEntity);

        musicModel.setArtist(artistModel);

        logger.info("Música de id " + idMusic + " encontrada com sucesso.");

        return musicModel;
    }

    public String toLowerCase(String word){
        return word.toLowerCase();
    }
}
