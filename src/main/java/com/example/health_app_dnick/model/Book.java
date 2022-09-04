package com.example.health_app_dnick.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "book_meals")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String author;

    private int stock;

    private float rating;

    private String description;

    private String url;

    private int counter;

    @ManyToOne
    @NotNull
    private Category category;


    public Book() {
    }

    public Book(String name, String author, int stock, float rating, String description, String url, Category category) {
        this.name = name;
        this.author = author;
        this.stock = stock;
        this.rating = rating;
        this.description = description;
        this.category = category;
        this.url = url;
        this.counter = 0;
    }

    public void rate(float rating) {
        counter = counter + 1;
        this.rating = ((counter-1)*this.rating + rating)/counter;
    }
}

