package com.ciandt.summit.user.port.in;

import java.util.UUID;

public record ManipulatingMusicInPlaylistDTO(
        UUID idPlaylist,
        UUID idMusic
) {
}
