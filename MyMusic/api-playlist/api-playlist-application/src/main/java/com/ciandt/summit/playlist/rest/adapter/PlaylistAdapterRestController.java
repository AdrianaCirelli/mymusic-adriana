package com.ciandt.summit.playlist.rest.adapter;

import com.ciandt.summit.playlist.PlaylistModel;
import com.ciandt.summit.playlist.dto.response.PlaylistResponseDto;
import com.ciandt.summit.playlist.ports.in.AddingMusicToPlaylistDTO;
import com.ciandt.summit.playlist.ports.in.PlaylistUseCasePort;
import com.ciandt.summit.playlist.rest.adapter.dto.RequestDtoAddingMusicToPlaylist;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Playlist endpoints")
@RestController
@RequestMapping("/api/v1/playlists")
public class PlaylistAdapterRestController {

    private final PlaylistUseCasePort playlistUseCasePort;

    public PlaylistAdapterRestController(
            PlaylistUseCasePort playlistUseCasePort) {

        this.playlistUseCasePort = playlistUseCasePort;
    }

    @Operation(summary = "Adds a music to the giving playlist")
    @PostMapping("/addMusic")
    ResponseEntity<PlaylistResponseDto> addingMusicToPlaylist(
            @RequestBody RequestDtoAddingMusicToPlaylist requestDto) {

        var addingMusicToPlaylistDTO = new AddingMusicToPlaylistDTO(
                requestDto.getIdPlaylist(),
                requestDto.getIdMusic());

        return ResponseEntity.status(HttpStatus.CREATED).body(
                playlistUseCasePort
                        .updatePlaylistByAddingMusic(addingMusicToPlaylistDTO)
        );
    }

    @Operation(summary = "Find a Singleton Resource of playlist by ID")
    @GetMapping("/{idPlaylist}")
    ResponseEntity<PlaylistResponseDto> findAllMusicsInPlaylist(@PathVariable UUID idPlaylist) {

        PlaylistModel playListById = playlistUseCasePort.getPlayListById(idPlaylist);

        PlaylistResponseDto dtoResponse = new PlaylistResponseDto(playListById);

        return ResponseEntity.ok(dtoResponse);
    }

    @Operation(summary = "Remove a music to the giving playlist")
    @PutMapping("/removeMusic")
    ResponseEntity<PlaylistResponseDto> removeMusicToPlaylist(
            //considerar renomer o nome da Request para reutiliza-lá nos métodos
            @RequestBody RequestDtoAddingMusicToPlaylist requestDto) {

        var removeMusicToPlaylistDTO = new AddingMusicToPlaylistDTO(
                requestDto.getIdPlaylist(),
                requestDto.getIdMusic());

        return ResponseEntity.status(HttpStatus.OK)
                .body(playlistUseCasePort.removeMusicToPlaylist(removeMusicToPlaylistDTO)
        );

    }

}
