package com.kirinsoft.onlinestore.onlinestore.user.repository;

import com.kirinsoft.onlinestore.onlinestore.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    UserEntity findByUserIdAndPassword(String userName, String password);
}
