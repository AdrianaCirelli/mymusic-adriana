package com.ciandt.summit.music.util.mapper;

import com.ciandt.summit.music.MusicModel;
import com.ciandt.summit.music.spring.repository.adapter.entity.MusicEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-13T15:13:03-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.4 (Oracle Corporation)"
)
@Component
public class MusicMapperImpl extends MusicMapper {

    @Override
    public MusicEntity convertToMusicEntity(MusicModel music) {
        if ( music == null ) {
            return null;
        }

        MusicEntity musicEntity = new MusicEntity();

        return musicEntity;
    }

    @Override
    public MusicModel convertToMusicModel(MusicEntity music) {
        if ( music == null ) {
            return null;
        }

        MusicModel musicModel = new MusicModel();

        musicModel.setId( music.getId() );
        musicModel.setName( music.getName() );

        return musicModel;
    }
}
