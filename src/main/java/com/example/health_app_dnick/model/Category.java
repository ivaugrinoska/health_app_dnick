package com.example.health_app_dnick.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "category_meals_new")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

}
