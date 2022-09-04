package com.example.health_app_dnick.web.rest;

import com.example.health_app_dnick.model.Book;
import com.example.health_app_dnick.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class RestBookController {

    private final BookService bookService;

    public RestBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> findAll() {
        return this.bookService.findAll();
    }


}
