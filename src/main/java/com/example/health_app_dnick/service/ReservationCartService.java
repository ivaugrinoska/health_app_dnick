package com.example.health_app_dnick.service;

import com.example.health_app_dnick.model.Book;
import com.example.health_app_dnick.model.ReservationCart;
import com.example.health_app_dnick.model.User;

import java.util.List;

public interface ReservationCartService {
    ReservationCart findCartByUser(User user);
    ReservationCart findById(Long id);
    ReservationCart addBookToReservationCart(String username, Long bookId);
    ReservationCart getActiveReservationCart(String username);
    List<Book> listAllBooksInReservationCart(Long id);
    void checkout(Long id);
}
