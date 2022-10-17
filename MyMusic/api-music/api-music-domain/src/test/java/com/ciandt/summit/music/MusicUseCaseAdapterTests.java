package com.ciandt.summit.music;

import com.ciandt.summit.music.adapters.MusicUseCaseAdapter;
import com.ciandt.summit.music.exception.InvalidParameterException;
import com.ciandt.summit.music.ports.out.MusicRepositoryPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MusicUseCaseAdapterTests {

    @Mock
    private MusicRepositoryPort musicRepositoryPort;

    @InjectMocks
    private MusicUseCaseAdapter musicUseCaseAdapter;

    /*
    @Test
    void testFindMusicAndArtistByFilter_Successfully() {

        Mockito.when(musicRepositoryPort.findMusicAndArtistByFilter("Future")).thenReturn(mockUseCaseAdapter());

        var filterOrdered = musicUseCaseAdapter.findMusicsByFilterOrdered("Future");

        filterOrdered.forEach( m -> System.out.println(m.getArtist().getName() + " - " + m.getName()));

        assertAll(
                () -> assertEquals("Paramore", filterOrdered.get(4).getArtist().getName()),
                () -> assertEquals("Future", filterOrdered.get(4).getName()),
                () -> assertEquals("Paramore", filterOrdered.get(5).getArtist().getName()),
                () -> assertEquals("Hard Times", filterOrdered.get(5).getName()),
                () -> assertEquals("Paramore", filterOrdered.get(6).getArtist().getName()),
                () -> assertEquals("Idle Worship", filterOrdered.get(6).getName())
        );
    }

    @Test
    void testFindMusicAndArtistByFilter_ThrowsException() {

        InvalidParameterException thrown = assertThrows(
                InvalidParameterException.class, () ->
                        musicUseCaseAdapter.findMusicsByFilterOrdered("x")
        );
        assertTrue(thrown.getMessage().contains(
                "Não foi possível realizar a busca. Insira um parâmetro com pelo menos 2 caracteres."));

    }

    private List<MusicModel> mockUseCaseAdapter() {

        List<MusicModel> list = new ArrayList<>();

        ArtistModel billieEilish = new ArtistModel(UUID.randomUUID(), "Billie Eilish", list);
        MusicModel myFuture = new MusicModel(UUID.randomUUID(), "My Future", billieEilish);

        ArtistModel paramore = new ArtistModel(UUID.randomUUID(), "Paramore", list);

        MusicModel future = new MusicModel(UUID.randomUUID(), "Future", paramore);
        MusicModel idleWorship = new MusicModel(UUID.randomUUID(), "Idle Worship", paramore);
        MusicModel hardTimes = new MusicModel(UUID.randomUUID(), "Hard Times", paramore);

        ArtistModel duaLipa = new ArtistModel(UUID.randomUUID(), "Dua Lipa", list);

        MusicModel futureNostalgia = new MusicModel(UUID.randomUUID(), "Future Nostalgia", duaLipa);
        MusicModel cool = new MusicModel(UUID.randomUUID(), "Cool", duaLipa);

        ArtistModel futureBand = new ArtistModel(UUID.randomUUID(), "Future", list);

        MusicModel neverStop = new MusicModel(UUID.randomUUID(), "Never Stop", futureBand);

        list.add(myFuture);
        list.add(future);
        list.add(futureNostalgia);
        list.add(idleWorship);
        list.add(hardTimes);
        list.add(cool);
        list.add(neverStop);

        return list;
    }
    */
}
