package com.ciandt.summit.user.token;

import com.ciandt.summit.user.token.dto.TokenAuthorizationWrapperDto;
import com.ciandt.summit.user.token.dto.TokenCreationWrapperDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "token-provider-api")
public interface TokenProviderProxy {

    @PostMapping(value = "/api/v1/token")
    String requestCreationToken(@RequestBody TokenCreationWrapperDto creationWrapperDto);

    @PostMapping(value = "/api/v1/token/authorizer")
    void requestTokenValidation(@RequestBody TokenAuthorizationWrapperDto authorizationRequest);


}