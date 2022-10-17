package com.ciandt.summit.music.spring.repository.exception;

public class MusicNotFoundException extends RuntimeException {

    public MusicNotFoundException(String message) {
        super(message);
    }
}
