package com.example.health_app_dnick.model.exceptions;

public class PasswordsDoNotMatchException extends RuntimeException{
    public PasswordsDoNotMatchException() {
        super("Passwords do not match exception.");
    }
}
