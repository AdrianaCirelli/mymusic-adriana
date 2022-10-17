package com.ciandt.summit.playlist.rest.adapter;


import com.ciandt.summit.playlist.exceptions.MusicAlreadyAddException;
import com.ciandt.summit.playlist.exceptions.MusicNotFoundException;
import com.ciandt.summit.playlist.exceptions.MusicNotPresentInPlaylist;
import com.ciandt.summit.playlist.exceptions.PlaylistNotFoundException;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ApiExceptionHandler {

    static final Logger logger = Logger.getLogger(ApiExceptionHandler.class);

    @ExceptionHandler(MusicAlreadyAddException.class)
    public ResponseEntity<String> handleMusicAlreadyAddedException(
            MusicAlreadyAddException ex, WebRequest request) {

        logger.warn("A música informada já existe na playlist.");

        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(MusicNotFoundException.class)
    public ResponseEntity<String> handleMusicNotFoundException(MusicNotFoundException ex, WebRequest request) {

        logger.warn("Música não encontrada.");

        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(PlaylistNotFoundException.class)
    public ResponseEntity<String> handleMusicNotFoundException(PlaylistNotFoundException ex, WebRequest request) {

        logger.warn("Playlist não encontrada.");

        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(MusicNotPresentInPlaylist.class)
    public ResponseEntity<String> handleMusicNotPresentInPlaylistException(MusicNotPresentInPlaylist ex, WebRequest request) {

        logger.warn("Este conteúdo não existe na Playlist.");

        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

}
