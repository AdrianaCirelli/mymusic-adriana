package com.ciandt.summit.music.rest.adapter;

import com.ciandt.summit.music.exception.InvalidParameterException;
import com.ciandt.summit.music.spring.repository.exception.MusicNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(InvalidParameterException.class)
    public ResponseEntity<String> handleInvalidFilterException(InvalidParameterException ex, WebRequest request) {

        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(MusicNotFoundException.class)
    public ResponseEntity<String> handleMusicNotFoundException(MusicNotFoundException ex, WebRequest request) {

        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
