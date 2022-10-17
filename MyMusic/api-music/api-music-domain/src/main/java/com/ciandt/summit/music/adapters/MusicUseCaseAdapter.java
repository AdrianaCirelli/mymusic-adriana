package com.ciandt.summit.music.adapters;

import com.ciandt.summit.music.MusicModel;
import com.ciandt.summit.music.exception.InvalidParameterException;
import com.ciandt.summit.music.ports.in.MusicUseCasePort;
import com.ciandt.summit.music.ports.out.MusicRepositoryPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.apache.log4j.Logger;

import java.util.*;

public class MusicUseCaseAdapter implements MusicUseCasePort {

    private final MusicRepositoryPort musicRepositoryPort;

    static final Logger logger = Logger.getLogger(MusicUseCaseAdapter.class);

    public MusicUseCaseAdapter(MusicRepositoryPort musicRepositoryPort) {
        this.musicRepositoryPort = musicRepositoryPort;
    }

    @Override
    public Page<MusicModel> findMusicsByFilterOrdered(String filter, Pageable pageable) {

        logger.info("Iniciando busca de músicas por filtro.");
        verifyFilterParameter(filter);

        Page<MusicModel> pageOfMusics = musicRepositoryPort.findMusicAndArtistByFilter(filter, pageable);

        logger.info("Busca de músicas por filtro realizada com sucesso.");
        return orderPage(pageOfMusics);
    }

    @Override
    public MusicModel findMusicByUUID(UUID idMusic) {
        return musicRepositoryPort.findMusicById(idMusic);
    }

    private void verifyFilterParameter(String filter) {

        if (filter.length() < 2 || filter.isBlank()) {
            logger.warn("Não foi possível realizar a busca. Insira um parâmetro com pelo menos 2 caracteres.");
            throw new InvalidParameterException
                    ("Não foi possível realizar a busca. Insira um parâmetro com pelo menos 2 caracteres.");
        }
    }

    private Page<MusicModel> orderPage(Page<MusicModel> pageOfMusics) {

         return new PageImpl<>(
                 pageOfMusics
                .stream()
                .sorted(
                        Comparator.comparing((MusicModel music) -> music.getArtist().getName())
                                .thenComparing(MusicModel::getName)
                ).toList()
         );
    }

}
