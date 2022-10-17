package com.ciandt.summit.user.rest.adapter;

import com.ciandt.summit.user.exception.GetPremiumException;
import com.ciandt.summit.user.exception.UserNotFoundException;
import com.ciandt.summit.user.exception.security.InvalidTokenException;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


import javax.servlet.http.HttpServletResponse;
import java.security.InvalidParameterException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestControllerAdvice
public class ApiUserExceptionHandler {

    @ExceptionHandler(InvalidParameterException.class)
    public ResponseEntity<String> handleInvalidFilterException(InvalidParameterException ex, WebRequest request) {

        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<String> handleInvalidTokenException(InvalidTokenException ex, WebRequest request) {

        return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {

        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(GetPremiumException.class)
    public ResponseEntity<String> handleGetPremiumException(GetPremiumException ex, WebRequest request) {

        return  ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
    }

    @ExceptionHandler(FeignException.NotFound.class)
    public ResponseEntity<String> handleFeignNotFoundException(FeignException ex, HttpServletResponse response) {

        Pattern p = Pattern.compile("\\:\\s\\[(?<msg>.*?)\\]");
        String msg = ex.getMessage();
        Matcher m = p.matcher(msg);
        String retornoNaoTratado = null;
        while (m.find()) {
            retornoNaoTratado = m.group();
        }

        Pattern p1 = Pattern.compile("(?<=\\[).+?(?=\\])");
        Matcher m1 = p1.matcher(retornoNaoTratado);

        String retornoTratado = null;
        while (m1.find()) {
            retornoTratado = m1.group();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(retornoTratado);
    }

    @ExceptionHandler(FeignException.BadRequest.class)
    public ResponseEntity<String> handleFeignBadRequestException(FeignException ex, HttpServletResponse response) {

        Pattern p = Pattern.compile("\\:\\s\\[(?<msg>.*?)\\]");
        String msg = ex.getMessage();
        Matcher m = p.matcher(msg);
        String retornoNaoTratado = null;
        while (m.find()) {
            retornoNaoTratado = m.group();
        }

        Pattern p1 = Pattern.compile("(?<=\\[).+?(?=\\])");
        Matcher m1 = p1.matcher(retornoNaoTratado);

        String retornoTratado = null;
        while (m1.find()) {
            retornoTratado = m1.group();
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(retornoTratado);
    }

}
