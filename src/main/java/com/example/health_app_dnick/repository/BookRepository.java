package com.example.health_app_dnick.repository;

import com.example.health_app_dnick.model.Book;
import com.example.health_app_dnick.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByCategory(Category category);

    List<Book> findFirst3ByCategory(Category c);

    List<Book> findTop3ByOrderByRatingDesc();

    void deleteByName(String name);

    Book findBookByName(String name);

    List<Book> findAllByOrderByCategoryAsc();

}
