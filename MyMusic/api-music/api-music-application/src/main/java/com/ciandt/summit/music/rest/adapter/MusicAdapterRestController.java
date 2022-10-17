package com.ciandt.summit.music.rest.adapter;

import com.ciandt.summit.music.ports.in.MusicUseCasePort;
import com.ciandt.summit.music.rest.adapter.dtoResponse.DataDtoResponse;
import com.ciandt.summit.music.rest.adapter.dtoResponse.MusicDtoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Music endpoints")
@RestController
@RequestMapping("/api/v1/musics")
public class MusicAdapterRestController {

    private final MusicUseCasePort musicUseCasePort;

    public MusicAdapterRestController(MusicUseCasePort musicUseCasePort) {
        this.musicUseCasePort = musicUseCasePort;
    }

    @Operation(summary = "Find a Singleton Resource of music by ID")
    @GetMapping("/{uuidMusic}")
    public ResponseEntity<MusicDtoResponse> findMusicById(
            @PathVariable UUID uuidMusic){

        var dtoMusic = new MusicDtoResponse(musicUseCasePort.findMusicByUUID(uuidMusic));
        return ResponseEntity.ok(dtoMusic);
    }

    @Operation(summary = "Find a collection resources of musics that name and artist name matchs the given filter")
    @GetMapping
    ResponseEntity<DataDtoResponse> findMusicByName(
            Pageable pageable,
            @RequestParam(name ="filtro", required = false) String filter){

        if(filter == null || filter.isBlank()){
            return ResponseEntity.noContent().build();
        }

        var orderedPageOfMusics = musicUseCasePort.findMusicsByFilterOrdered(filter, pageable);

        if(orderedPageOfMusics.isEmpty() ){
            return ResponseEntity.noContent().build();
        }

        var orderedPageOfMusicsDTO = orderedPageOfMusics
                .map(musicModel -> new MusicDtoResponse().toDtoMusic(musicModel));

        return ResponseEntity.status(HttpStatus.OK).body(new DataDtoResponse(orderedPageOfMusicsDTO));
    }
}
