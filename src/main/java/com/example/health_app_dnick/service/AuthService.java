package com.example.health_app_dnick.service;

import com.example.health_app_dnick.model.User;

public interface AuthService {

    User login(String username, String password);

    User editProfile(String username, String name, String surname);
}

