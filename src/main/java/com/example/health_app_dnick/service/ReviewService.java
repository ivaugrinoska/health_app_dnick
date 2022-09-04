package com.example.health_app_dnick.service;

import com.example.health_app_dnick.model.Book;
import com.example.health_app_dnick.model.Review;
import com.example.health_app_dnick.model.User;

import java.util.List;

public interface ReviewService {
    List<Review> findReviewsByBook(Book book);

    Review addNewReview(String review, Long bookId, User user);
}
