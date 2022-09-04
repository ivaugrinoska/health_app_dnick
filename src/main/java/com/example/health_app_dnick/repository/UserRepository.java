package com.example.health_app_dnick.repository;

import com.example.health_app_dnick.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);

    User findUserByUsername(String username);

    Optional<User> findByUsernameAndPassword(String username, String password);
}
