package com.example.health_app_dnick.service.impl;
import com.example.health_app_dnick.model.Book;
import com.example.health_app_dnick.model.Review;
import com.example.health_app_dnick.model.User;
import com.example.health_app_dnick.repository.BookRepository;
import com.example.health_app_dnick.repository.ReviewRepository;
import com.example.health_app_dnick.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository repository;
    private final BookRepository bookRepository;

    public ReviewServiceImpl(ReviewRepository repository, BookRepository bookRepository) {
        this.repository = repository;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Review> findReviewsByBook(Book book) {
        return repository.findAllByBook(book);
    }

    @Override
    public Review addNewReview(String review, Long bookId, User user) {
        Book book = bookRepository.getById(bookId);
        Review r = new Review(review,user,book);
        return repository.save(r);
    }
}
