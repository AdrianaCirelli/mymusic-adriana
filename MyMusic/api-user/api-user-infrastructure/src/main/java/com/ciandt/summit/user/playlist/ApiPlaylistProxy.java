package com.ciandt.summit.user.playlist;

import com.ciandt.summit.user.PlaylistModel;
import com.ciandt.summit.user.port.in.ManipulatingMusicInPlaylistDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@FeignClient("api-playlist")
public interface ApiPlaylistProxy {

    @GetMapping("/api/v1/playlists/{idPlaylist}")
    PlaylistModel getPlaylistById(@PathVariable("idPlaylist") UUID idPlaylist);

    @PutMapping("/api/v1/playlists/removeMusic")
    PlaylistModel removeMusicFromPlaylist(@RequestBody ManipulatingMusicInPlaylistDTO requestDto);

    @PostMapping("/api/v1/playlists/addMusic")
    PlaylistModel addMusicToPlaylist(@RequestBody ManipulatingMusicInPlaylistDTO requestDto);

}
