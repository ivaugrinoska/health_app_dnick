package com.example.health_app_dnick.service.impl;
import com.example.health_app_dnick.repository.ReservationCartBooksRepository;
import com.example.health_app_dnick.service.ReservationCartBooksService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ReservationCartBooksServiceImpl implements ReservationCartBooksService {

    private final ReservationCartBooksRepository reservationCartBooksRepository;

    public ReservationCartBooksServiceImpl(ReservationCartBooksRepository reservationCartBooksRepository) {
        this.reservationCartBooksRepository = reservationCartBooksRepository;
    }


    @Override
    @Transactional
    public void deleteAllByResCartId(Long id) {
        this.reservationCartBooksRepository.deleteReservationCartBooksByResCartId(id);
    }
}
