package com.example.health_app_dnick.repository;

import com.example.health_app_dnick.model.Book;
import com.example.health_app_dnick.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByBook(Book book);
}
