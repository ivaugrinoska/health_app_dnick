package com.example.health_app_dnick.service.impl;
import com.example.health_app_dnick.model.User;
import com.example.health_app_dnick.model.exceptions.InvalidArgumentsException;
import com.example.health_app_dnick.model.exceptions.InvalidUserCredentialsException;
import com.example.health_app_dnick.model.exceptions.UserNotFoundException;
import com.example.health_app_dnick.repository.UserRepository;
import com.example.health_app_dnick.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class  AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        return userRepository.findByUsernameAndPassword(username, password).orElseThrow(InvalidUserCredentialsException::new);

    }

    @Override
    public User editProfile(String username, String name, String surname) {

        User user = this.userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));

        user.setName(name);
        user.setSurname(surname);

        return this.userRepository.save(user);
    }
}
