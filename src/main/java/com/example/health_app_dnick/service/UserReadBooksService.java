package com.example.health_app_dnick.service;

import com.example.health_app_dnick.model.Book;
import com.example.health_app_dnick.model.User;

import java.util.List;

public interface UserReadBooksService {

    User addBookToProfile(String username, Long bookId);
    List<Book> listAllBooksInProfile(String username);
}
