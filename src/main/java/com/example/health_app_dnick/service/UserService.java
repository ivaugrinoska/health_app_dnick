package com.example.health_app_dnick.service;

import com.example.health_app_dnick.model.User;
import com.example.health_app_dnick.model.enumerations.Role;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User register(String username, String password, String repeatPassword, String name, String surname, Role role);

    User findUserByUsername(String username);
}