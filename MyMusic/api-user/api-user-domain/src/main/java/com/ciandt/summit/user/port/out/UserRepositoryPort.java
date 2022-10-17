package com.ciandt.summit.user.port.out;


import com.ciandt.summit.user.UserModel;
import java.util.UUID;

public interface UserRepositoryPort {

    UserModel findUserById(UUID idUser);

    UserModel findUserByName(String name);

}
