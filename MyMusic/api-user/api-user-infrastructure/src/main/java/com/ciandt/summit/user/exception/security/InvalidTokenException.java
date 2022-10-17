package com.ciandt.summit.user.exception.security;

public class InvalidTokenException extends  RuntimeException{

    public InvalidTokenException(String message) {
        super(message);
    }
}
