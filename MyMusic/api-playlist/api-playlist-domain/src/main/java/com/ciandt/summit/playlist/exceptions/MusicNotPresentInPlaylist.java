package com.ciandt.summit.playlist.exceptions;

public class MusicNotPresentInPlaylist extends RuntimeException {

    public MusicNotPresentInPlaylist(String message) {
        super(message);
    }

    public MusicNotPresentInPlaylist(String message, Throwable cause) {
        super(message, cause);
    }

}