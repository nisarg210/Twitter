package com.twitter.user_service.repositories;

import com.twitter.user_service.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    @Query("SELECT u FROM UserEntity u WHERE u.username=?1")
    public UserEntity getUserByUsername(String username);

}
