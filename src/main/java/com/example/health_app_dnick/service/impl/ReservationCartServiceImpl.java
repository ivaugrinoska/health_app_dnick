package com.example.health_app_dnick.service.impl;
import com.example.health_app_dnick.model.Book;
import com.example.health_app_dnick.model.ReservationCart;
import com.example.health_app_dnick.model.User;
import com.example.health_app_dnick.model.exceptions.BookAlreadyInReservationCartException;
import com.example.health_app_dnick.model.exceptions.BookNotFoundException;
import com.example.health_app_dnick.model.exceptions.ReservationCartNotFoundException;
import com.example.health_app_dnick.model.exceptions.UserNotFoundException;
import com.example.health_app_dnick.repository.BookRepository;
import com.example.health_app_dnick.repository.ReservationCartRepository;
import com.example.health_app_dnick.repository.UserRepository;
import com.example.health_app_dnick.service.ReservationCartService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationCartServiceImpl implements ReservationCartService {

    private final ReservationCartRepository reservationCartRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public ReservationCartServiceImpl(ReservationCartRepository reservationCartRepository, UserRepository userRepository, BookRepository bookRepository) {
        this.reservationCartRepository = reservationCartRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }


    @Override
    public ReservationCart findCartByUser(User user) {
        if (reservationCartRepository.findReservationCartByUser(user) != null) {
            return reservationCartRepository.findReservationCartByUser(user);
        }
        else
            return reservationCartRepository.save(new ReservationCart(user));
    }

    @Override
    public ReservationCart findById(Long id) {
        return this.reservationCartRepository.findById(id).get();
    }

    @Override
    public ReservationCart getActiveReservationCart(String username) {

        User user = this.userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
        ReservationCart reservationCart = this.reservationCartRepository.
                findReservationCartByUser(user);
        return reservationCart;


    }

    @Override
    public ReservationCart addBookToReservationCart(String username, Long bookId) {
        ReservationCart reservationCart = this.getActiveReservationCart(username);
        Book book = this.bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId));
        if(reservationCart.getBooks()
                .stream().filter(i -> i.getId().equals(bookId))
                .collect(Collectors.toList()).size() > 0)
            throw new BookAlreadyInReservationCartException(bookId, username);
        book = this.bookRepository.save(book);
        reservationCart.getBooks().add(book);
        return this.reservationCartRepository.save(reservationCart);
    }

    @Override
    public List<Book> listAllBooksInReservationCart(Long cartId) {
        if(!this.reservationCartRepository.findById(cartId).isPresent())
            throw new ReservationCartNotFoundException(cartId);
        return this.reservationCartRepository.findById(cartId).get().getBooks();

    }

    @Override
    public void checkout(Long id) {
        List<Book> books = this.bookRepository.findAll();

        books = this.bookRepository.saveAll(books);

    }

}
