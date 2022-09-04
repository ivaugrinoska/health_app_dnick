package com.example.health_app_dnick.model;
import com.example.health_app_dnick.model.pk.ReservationCartBooksPK;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "reservation_cart_meals",
        schema = "public", catalog = "meals")
@IdClass(ReservationCartBooksPK.class)
public class ReservationCartBooks {

    @Id
    private Long resCartId;
    @Id
    private Long bookId;
    private boolean status;

    public ReservationCartBooks() {
    }

    public ReservationCartBooks(Long resCartId, Long bookId) {
        this.resCartId = resCartId;
        this.bookId = bookId;
    }

    @Column(name = "reservation_cart_id_meals")
    @Id
    public Long getResCartId() {
        return resCartId;
    }

    public void setResCartId(Long resCartId) {
        this.resCartId = resCartId;
    }

    @Column(name = "meals_id")
    @Id
    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationCartBooks that = (ReservationCartBooks) o;
        return Objects.equals(resCartId, that.resCartId) &&
                Objects.equals(bookId, that.bookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resCartId, bookId);
    }

}
