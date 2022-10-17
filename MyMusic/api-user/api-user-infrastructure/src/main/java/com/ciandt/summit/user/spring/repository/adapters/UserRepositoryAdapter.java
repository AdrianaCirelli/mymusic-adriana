package com.ciandt.summit.user.spring.repository.adapters;


import com.ciandt.summit.user.UserModel;
import com.ciandt.summit.user.exception.UserNotFoundException;
import com.ciandt.summit.user.mapper.UserMapper;
import com.ciandt.summit.user.port.out.UserRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final UserRepository userRepository;

    public UserRepositoryAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserModel findUserById(UUID idUser) {

        var userEntity = userRepository.findById(idUser).orElseThrow(()->
                new UserNotFoundException("Usuário nao encontrado.")
        );

        return UserMapper.INSTANCE.convertToUserModel(userEntity);
    }

    @Override
    public UserModel findUserByName(String name) {

        var userEntity = userRepository.findUserByName(name).orElseThrow(()->
                new UserNotFoundException("Usuário nao encontrado.")
        );

        return UserMapper.INSTANCE.convertToUserModel(userEntity);
    }

}
