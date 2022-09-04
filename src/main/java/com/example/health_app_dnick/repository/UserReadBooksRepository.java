package com.example.health_app_dnick.repository;

import com.example.health_app_dnick.model.UserReadBooks;
import com.example.health_app_dnick.model.pk.UserReadBooksPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReadBooksRepository extends JpaRepository<UserReadBooks, UserReadBooksPK> {

}
