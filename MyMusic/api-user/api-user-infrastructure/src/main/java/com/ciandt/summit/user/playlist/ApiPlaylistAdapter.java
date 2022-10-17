package com.ciandt.summit.user.playlist;

import com.ciandt.summit.user.PlaylistModel;
import com.ciandt.summit.user.UserModel;
import com.ciandt.summit.user.port.in.ManipulatingMusicInPlaylistDTO;
import com.ciandt.summit.user.port.out.ApiPlaylistPort;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ApiPlaylistAdapter implements ApiPlaylistPort {


    private final ApiPlaylistProxy apiPlaylistProxy;

    public ApiPlaylistAdapter(ApiPlaylistProxy apiPlaylistProxy) {
        this.apiPlaylistProxy = apiPlaylistProxy;
    }

    @Override
    public PlaylistModel getPlaylistByUser(UserModel user) {
        UUID idPlaylist = user.getPlaylist().getId();
        return apiPlaylistProxy.getPlaylistById(idPlaylist);
    }

    @Override
    public PlaylistModel removeMusic(ManipulatingMusicInPlaylistDTO dto) {

        var playlist = apiPlaylistProxy.removeMusicFromPlaylist(dto);

        return playlist;
    }

    @Override
    public PlaylistModel addMusic(ManipulatingMusicInPlaylistDTO dto) {
        var playlist = apiPlaylistProxy.addMusicToPlaylist(dto);

        return playlist;
    }
}
