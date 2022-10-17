package com.ciandt.summit.playlist;

import com.ciandt.summit.playlist.exceptions.MusicAlreadyAddException;
import com.ciandt.summit.playlist.exceptions.MusicNotPresentInPlaylist;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class PlaylistModel {

    private UUID id;

    private List<MusicModel> musics;


    public PlaylistModel() {
    }

    public PlaylistModel(UUID id, List<MusicModel> musics) {
        this.id = id;
        this.musics = musics;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<MusicModel> getMusics() {
        return musics;
    }

    public void setMusics(List<MusicModel> musics) {
        this.musics = musics;
    }

    public void addMusic(MusicModel music){
        validateMusic(music);

        if(this.musics == null) {
            this.musics = new ArrayList<>();
        }

        if(this.musics.contains(music)){
            throw new MusicAlreadyAddException("A musica '"+music.getName()+"' ja esta adicionada na playlist");
        }

        music.setPlaylist(this);
        this.musics.add(music);
    }

    public boolean validateMusic(MusicModel music){
        if (Objects.isNull(music)){
            throw new IllegalArgumentException("Música Inválida!"); //TODO pode haver uma Exceção Personalizada aqui
        }
        return true;
    }



    public void removeMusic (MusicModel music){
        validateMusic(music);

        if(this.musics == null ){
            this.musics = new ArrayList<>();
        }

        if (!this.musics.contains(music)){

            throw new MusicNotPresentInPlaylist("Este conteúdo não existe na playlist");
        }

        this.musics.remove(music);

    }

}
