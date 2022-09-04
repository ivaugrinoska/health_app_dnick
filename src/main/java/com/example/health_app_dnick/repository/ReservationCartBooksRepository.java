package com.example.health_app_dnick.repository;

import com.example.health_app_dnick.model.ReservationCartBooks;
import com.example.health_app_dnick.model.pk.ReservationCartBooksPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationCartBooksRepository extends
        JpaRepository<ReservationCartBooks, ReservationCartBooksPK> {
    @Modifying
    @Query("delete from ReservationCartBooks rcb where rcb.resCartId = ?1")
    void deleteReservationCartBooksByResCartId(Long id);
}
