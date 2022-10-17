package com.ciandt.summit.user.spring.repository.adapters;

import com.ciandt.summit.user.spring.repository.adapters.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository <UserEntity, UUID> {

    @Query("SELECT u FROM UserEntity u WHERE lower(u.name) = :name")
    Optional<UserEntity> findUserByName(@Param("name") String name);

}
