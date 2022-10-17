import com.ciandt.summit.playlist.ArtistModel;
import com.ciandt.summit.playlist.MusicModel;
import com.ciandt.summit.playlist.PlaylistModel;
import com.ciandt.summit.playlist.adapter.PlaylistUseCaseAdapter;
import com.ciandt.summit.playlist.ports.in.AddingMusicToPlaylistDTO;
import com.ciandt.summit.playlist.dto.response.PlaylistResponseDto;
import com.ciandt.summit.playlist.exceptions.MusicNotFoundException;
import com.ciandt.summit.playlist.exceptions.PlaylistNotFoundException;
import com.ciandt.summit.playlist.ports.out.ApiMusicPort;
import com.ciandt.summit.playlist.ports.out.PlaylistRepositoryPort;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PlaylistUseCaseAdapterTests {

    @Mock
    PlaylistRepositoryPort playlistRepositoryPort;

    @Mock
    ApiMusicPort apiMusicPort;

    @InjectMocks
    PlaylistUseCaseAdapter playlistUseCaseAdapter;

    PlaylistModel playlistModel;
    ArtistModel artistModel;

    @BeforeAll
    void setup(){
        playlistModel = new PlaylistModel(UUID.fromString("fc642c89-d3fe-424c-8c3b-4b71f52a3e4f"), new ArrayList<>());

        artistModel = new ArtistModel(UUID.randomUUID(), "Lukaz");
        MusicModel musicModel = new MusicModel(UUID.randomUUID(), "Vou vencer o Java", artistModel, playlistModel);

        playlistModel.getMusics().add(musicModel);
    }

    @Test
    @DisplayName("Retornar exceção caso a Música não seja encontrada")
    public void shouldReturnExceptionIfMusicNotFound(){

        AddingMusicToPlaylistDTO addingMusicToPlaylistDTO = new AddingMusicToPlaylistDTO(UUID.fromString("fc642c89-d3fe-424c-8c3b-4b71f52a3e4f"),
                UUID.fromString("356e4d4e-703c-427a-be52-2579a8544c37"));

        Mockito.when(apiMusicPort.findMusicById(UUID.fromString("356e4d4e-703c-427a-be52-2579a8544c37"))).thenReturn(Optional.empty());

        Assertions.assertThrows(MusicNotFoundException.class, () ->{
            playlistUseCaseAdapter.findMusicById(addingMusicToPlaylistDTO);
        });

    }

    @Test
    @DisplayName("Retornar a Música encontrada")
    public void shouldReturnMusicFound(){

        AddingMusicToPlaylistDTO addingMusicToPlaylistDTO = new AddingMusicToPlaylistDTO(UUID.fromString("fc642c89-d3fe-424c-8c3b-4b71f52a3e4f"),
                UUID.fromString("ca36ab08-239b-490a-9158-3ecd3179ded8"));

        Mockito.when(apiMusicPort.findMusicById(UUID.fromString("ca36ab08-239b-490a-9158-3ecd3179ded8"))).thenReturn(mockOptionalMusicModel());

        Assertions.assertEquals("Música Teste",
                playlistUseCaseAdapter.findMusicById(addingMusicToPlaylistDTO).getName()
        );

    }

    @Test
    @DisplayName("Retornar exceção caso a Playlist não seja encontrada")
    public void shouldReturnExceptionIfPlaylistNotFound(){

        Mockito.when(playlistRepositoryPort.findPlaylistById(UUID.fromString("9f49d326-4ad6-433c-af23-195f1cf0da8d"))).thenCallRealMethod();

        Assertions.assertThrows(PlaylistNotFoundException.class, () ->{
            playlistUseCaseAdapter.getPlayListById(UUID.fromString("9f49d326-4ad6-433c-af23-195f1cf0da8d"));
        });

    }

    @Test
    @DisplayName("Retornar a Playlist encontrada")
    public void shouldReturnPlaylistFound(){

        Mockito.when(playlistRepositoryPort.findPlaylistById(UUID.fromString("9101e79c-3f60-11ed-b878-0242ac120002"))).thenReturn(mockOptionalPlaylistModel().get());

        Assertions.assertEquals("Música Teste",
                playlistUseCaseAdapter.getPlayListById(UUID.fromString("9101e79c-3f60-11ed-b878-0242ac120002"))
                        .getMusics().get(0).getName()
        );

    }

    @Test
    @DisplayName("Salvar nova Música na Playlist")
    public void shouldAddNewMusicToExistentPlaylist(){

        MusicModel musicModel = new MusicModel(UUID.fromString("ce719027-f824-4f5d-87f6-e34b519f0371"), "Vou vencer os Testes", artistModel, null);

        Mockito.when(playlistRepositoryPort.findPlaylistById(UUID.fromString("fc642c89-d3fe-424c-8c3b-4b71f52a3e4f"))).thenReturn(playlistModel);
        Mockito.when(apiMusicPort.findMusicById(UUID.fromString("ce719027-f824-4f5d-87f6-e34b519f0371"))).thenReturn(Optional.of(musicModel));
        Mockito.when(playlistRepositoryPort.savePlaylist(playlistModel)).thenReturn(mockUpdatedPlaylist());

        PlaylistResponseDto playlistModelAtualizada = playlistUseCaseAdapter.updatePlaylistByAddingMusic(
                new AddingMusicToPlaylistDTO(
                        playlistModel.getId(),
                        UUID.fromString("ce719027-f824-4f5d-87f6-e34b519f0371")));

        Assertions.assertEquals(2, playlistModelAtualizada.getMusics().size());

    }

    @Test
    @DisplayName("Remover Música na Playlist")
    public void shouldRemoveMusicToExistentPlaylist(){

        MusicModel musicToRemove = new MusicModel(UUID.fromString("ce719027-f824-4f5d-87f6-e34b519f0371"), "Vou vencer os Testes", artistModel, null);

        Mockito.when(playlistRepositoryPort.findPlaylistById(UUID.fromString("fc642c89-d3fe-424c-8c3b-4b71f52a3e4f"))).thenReturn(playlistModel);
        Mockito.when(apiMusicPort.findMusicById(UUID.fromString("ce719027-f824-4f5d-87f6-e34b519f0371"))).thenReturn(Optional.of(musicToRemove));
        Mockito.when(playlistRepositoryPort.savePlaylist(playlistModel)).thenReturn(mockUpdatedPlaylist());

        playlistModel.addMusic(musicToRemove);

        PlaylistResponseDto playlistModelAtualizada = playlistUseCaseAdapter.removeMusicToPlaylist(
                new AddingMusicToPlaylistDTO(
                        playlistModel.getId(),
                        UUID.fromString("ce719027-f824-4f5d-87f6-e34b519f0371")));

        Assertions.assertEquals(1, playlistModelAtualizada.getMusics().size());
        Assertions.assertFalse(playlistModel.getMusics().contains(musicToRemove));

    }

    private Optional<MusicModel> mockOptionalMusicModel() {

        ArtistModel artistModel = new ArtistModel(UUID.randomUUID(), "Artista Teste");
        MusicModel musicModel = new MusicModel(UUID.fromString("ca36ab08-239b-490a-9158-3ecd3179ded8"),"Música Teste", artistModel, null);

        return Optional.of(musicModel);

    }

    private Optional<PlaylistModel> mockOptionalPlaylistModel() {

        PlaylistModel playlistModel = new PlaylistModel(UUID.fromString("9101e79c-3f60-11ed-b878-0242ac120002"), new ArrayList<>());
        ArtistModel artistModel = new ArtistModel(UUID.randomUUID(), "Artista Teste");
        MusicModel musicModel = new MusicModel(UUID.randomUUID(),"Música Teste", artistModel, playlistModel);

        playlistModel.addMusic(musicModel);

        return Optional.of(playlistModel);

    }



    private PlaylistModel mockUpdatedPlaylist(){
        return playlistModel;
    }
}
