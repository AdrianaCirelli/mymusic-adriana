package com.ciandt.summit.user.spring.configuration.contextbeans;

import com.ciandt.summit.user.adapters.UserUseCaseAdapter;
import com.ciandt.summit.user.port.in.UserUseCasePort;
import com.ciandt.summit.user.port.out.ApiPlaylistPort;
import com.ciandt.summit.user.port.out.TokenProviderPort;
import com.ciandt.summit.user.port.out.UserRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserUseCasePortConfiguration {

    @Bean
    UserUseCasePort userUseCasePort(UserRepositoryPort userRepositoryPort,
                                    TokenProviderPort tokenProviderPort,
                                    ApiPlaylistPort apiPlaylistPort){
        return new UserUseCaseAdapter(userRepositoryPort, tokenProviderPort, apiPlaylistPort);
    }

}
