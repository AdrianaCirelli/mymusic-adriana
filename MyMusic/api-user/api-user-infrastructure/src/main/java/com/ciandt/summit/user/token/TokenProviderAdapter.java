package com.ciandt.summit.user.token;

import com.ciandt.summit.user.exception.security.InvalidTokenException;
import com.ciandt.summit.user.port.out.TokenProviderPort;
import com.ciandt.summit.user.token.dto.TokenAuthorizationDataDto;
import com.ciandt.summit.user.token.dto.TokenAuthorizationWrapperDto;
import com.ciandt.summit.user.token.dto.TokenCreationDataDto;
import com.ciandt.summit.user.token.dto.TokenCreationWrapperDto;
import org.springframework.stereotype.Component;

@Component
public class TokenProviderAdapter implements TokenProviderPort {

    private final TokenProviderProxy tokenProviderProxy;


    public TokenProviderAdapter(TokenProviderProxy tokenProviderProxy) {
        this.tokenProviderProxy = tokenProviderProxy;
    }

    @Override
    public String requestToken(String username) {
        var creationData = new TokenCreationDataDto(username);
        var creationRequest = new TokenCreationWrapperDto(creationData);

        try {
            return this.tokenProviderProxy.requestCreationToken(creationRequest);
        } catch (Exception e) {
            throw new InvalidTokenException("Erro ao solicitar o Token.");
        }

    }

    @Override
    public void validateToken(String userName, String token) {

        var authorizationData = new TokenAuthorizationDataDto(userName, token);
        var authorizationRequest = new TokenAuthorizationWrapperDto(authorizationData);

        try {
            this.tokenProviderProxy.requestTokenValidation(authorizationRequest);
        } catch (Exception e) {
            throw new InvalidTokenException("Token Inválido.");
        }
    }
}