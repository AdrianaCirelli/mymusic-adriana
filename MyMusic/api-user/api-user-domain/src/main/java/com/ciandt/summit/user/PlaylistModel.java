package com.ciandt.summit.user;


import java.util.List;
import java.util.UUID;

public class PlaylistModel {

    private UUID id;

    private List<MusicModel> musics;

    //private UserModel user;

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

//    public UserModel getUser() {
//        return user;
//    }
//
//    public void setUser(UserModel user) {
//        this.user = user;
//    }
}
