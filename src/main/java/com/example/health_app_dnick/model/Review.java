package com.example.health_app_dnick.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "review_meals")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private LocalDate dateWritten;

    @ManyToOne
    @NotNull
    private User user;

    @ManyToOne
    @NotNull
    private Book book;

    public Review() {
    }

    public Review(String text, User user, Book book) {
        this.text = text;
        this.user = user;
        this.book = book;
        this.dateWritten=LocalDate.now();
    }
}
