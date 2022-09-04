package com.example.health_app_dnick.model.exceptions;

public class UsernameAlreadyExistsException extends RuntimeException{
    public UsernameAlreadyExistsException(String username){
        super(String.format("User with username: %s already exists", username));
    }
}