package com.ciandt.summit.user.port.out;

public interface TokenProviderPort {

    String requestToken(String username);
    void validateToken(String username, String token);
}
