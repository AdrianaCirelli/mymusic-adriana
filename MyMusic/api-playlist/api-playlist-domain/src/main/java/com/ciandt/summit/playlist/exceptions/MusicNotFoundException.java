package com.ciandt.summit.playlist.exceptions;

public class MusicNotFoundException extends RuntimeException {

    public MusicNotFoundException(String message) {
        super(message);
    }

    public MusicNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
