package com.ciandt.summit.user.rest.adapter;

import com.ciandt.summit.user.mapper.UserMapper;
import com.ciandt.summit.user.port.in.ManipulatingMusicInPlaylistDTO;
import com.ciandt.summit.user.port.in.UserUseCasePort;
import com.ciandt.summit.user.rest.adapter.dto.request.RequestDtoManipulateMusicInPlaylist;
import com.ciandt.summit.user.rest.adapter.dto.request.UserLoginDtoRequest;
import com.ciandt.summit.user.rest.adapter.dto.response.PlaylistDtoResponse;
import com.ciandt.summit.user.rest.adapter.dto.response.UserDtoResponse;
import com.ciandt.summit.user.rest.adapter.dto.response.UserLoginDtoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = " User endpoints")
@RestController
@RequestMapping("/api/v1/users")
public class UserAdapterRestController {

    private final UserUseCasePort userUseCasePort;

    public UserAdapterRestController(UserUseCasePort userUseCasePort) {

        this.userUseCasePort = userUseCasePort;
    }

    @Operation(summary = "Find a Singleton Resource of user by ID")
    @GetMapping("/{uuidUser}")
    public ResponseEntity<UserDtoResponse> findUserById(@PathVariable UUID uuidUser) {
        var dtoUser = new UserDtoResponse(userUseCasePort.findUserByUUID(uuidUser));

        return ResponseEntity.ok(dtoUser);
    }

    @GetMapping("/{uuidUser}/playlist")
    public ResponseEntity<PlaylistDtoResponse> getUserPlaylist(@PathVariable UUID uuidUser){

        var playlist = userUseCasePort.getUserPlaylist(uuidUser);

        PlaylistDtoResponse response = new PlaylistDtoResponse(playlist);

        return ResponseEntity.ok(response);
    }

    //Remover música da Playlist
    @DeleteMapping("/{uuidUser}/playlist/removeMusic")
    public ResponseEntity<PlaylistDtoResponse> deleteMusicFromPlaylist(@PathVariable UUID uuidUser,
                                                                       @RequestBody RequestDtoManipulateMusicInPlaylist removeMusicDto){

        var removingMusicToPlaylistDTO = new ManipulatingMusicInPlaylistDTO(
                removeMusicDto.getIdPlaylist(),
                removeMusicDto.getIdMusic());

        var playlistUpdated = new PlaylistDtoResponse(userUseCasePort.removeMusic(uuidUser, removingMusicToPlaylistDTO));

        return ResponseEntity.ok(playlistUpdated);
    }

    //Adicinar música na Playlist
    @PutMapping("/{uuidUser}/playlist/addMusic")
    public ResponseEntity<PlaylistDtoResponse> addMusicToPlaylist(@PathVariable UUID uuidUser,
                                                                  @RequestBody RequestDtoManipulateMusicInPlaylist removeMusicDto){
        var addingMusicToPlaylistDTO = new ManipulatingMusicInPlaylistDTO(
                removeMusicDto.getIdPlaylist(),
                removeMusicDto.getIdMusic());

        var playlistUpdated = new PlaylistDtoResponse(userUseCasePort.addMusicToPlaylist(uuidUser, addingMusicToPlaylistDTO));

        return ResponseEntity.ok(playlistUpdated);
    }


    @PostMapping("/login")
    public ResponseEntity<UserLoginDtoResponse> verifyUserLogin(@RequestBody UserLoginDtoRequest user) {

        UserLoginDtoResponse userLogin = new UserLoginDtoResponse(userUseCasePort.findUserByName(user.getUsername()));

        return ResponseEntity.ok(userLogin);
    }



}
