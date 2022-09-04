package com.example.health_app_dnick.repository;

import com.example.health_app_dnick.model.ReservationCart;
import com.example.health_app_dnick.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationCartRepository extends JpaRepository<ReservationCart, Long> {
    ReservationCart findReservationCartByUser(User user);
}
