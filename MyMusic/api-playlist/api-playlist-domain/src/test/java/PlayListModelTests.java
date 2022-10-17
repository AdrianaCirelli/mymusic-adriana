
import com.ciandt.summit.playlist.ArtistModel;
import com.ciandt.summit.playlist.MusicModel;
import com.ciandt.summit.playlist.PlaylistModel;
import com.ciandt.summit.playlist.adapter.PlaylistUseCaseAdapter;
import com.ciandt.summit.playlist.dto.response.PlaylistResponseDto;
import com.ciandt.summit.playlist.exceptions.MusicAlreadyAddException;
import com.ciandt.summit.playlist.exceptions.MusicNotPresentInPlaylist;
import com.ciandt.summit.playlist.ports.in.AddingMusicToPlaylistDTO;
import com.ciandt.summit.playlist.ports.in.PlaylistUseCasePort;
import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;


class PlayListModelTests {


    @Test
    void shouldAddMusicToPlayListSucces() {
        //given
        PlaylistModel playlistModel = new PlaylistModel();
        MusicModel musicModel = new MusicModel(UUID.randomUUID(), "Alejandro", null, null);

        //when
        playlistModel.addMusic(musicModel);

        //then
        Assertions.assertAll(
                () -> Assertions.assertEquals(musicModel, playlistModel.getMusics().get(0)),
                () -> Assertions.assertEquals(playlistModel, musicModel.getPlaylist()),
                () -> Assertions.assertEquals(1, playlistModel.getMusics().size())
        );


    }

    @Test
    void shouldThrowExceptionWhenMusicAlreadyExistsInPlayList() {

        PlaylistModel playlistModel = new PlaylistModel();
        MusicModel musicModel = new MusicModel(UUID.randomUUID(), "Alejandro", null, null);
        playlistModel.setMusics(Arrays.asList(musicModel));

        Assertions.assertThrows(MusicAlreadyAddException.class, () -> playlistModel.addMusic(musicModel));

    }

    @Test
    void shouldRemoveMusicToPlayList() {

        PlaylistModel playlistModel = new PlaylistModel();
        MusicModel musicToAdd = new MusicModel(UUID.randomUUID(), "Alejandro", null, null);
        playlistModel.addMusic(musicToAdd);

        playlistModel.removeMusic(musicToAdd);


        assertEquals(0, playlistModel.getMusics().size());
        assertFalse(playlistModel.getMusics().contains(musicToAdd));

    }

    @Test
    void shouldThrowExceptionToRemoveMusicIfMusicNotExistInPlayList() {

        PlaylistModel playlistModel = new PlaylistModel();
        MusicModel musicToAdd = new MusicModel(UUID.randomUUID(), "Alejandro", null, null);

        Assertions.assertThrows(MusicNotPresentInPlaylist.class, () -> playlistModel.removeMusic(musicToAdd));

    }

}

