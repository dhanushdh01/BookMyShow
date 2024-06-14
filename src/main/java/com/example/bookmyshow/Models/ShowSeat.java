package com.example.bookmyshow.Models;

import com.example.bookmyshow.Models.Constant.ShowSeatStatus;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ShowSeat extends BaseModel {
    private int price;
    private Show show;
    private Seat seat;
    private ShowSeatStatus showSeatStatus;

    public ShowSeat() {
    }

    public ShowSeat(int price, Show show, Seat seat, ShowSeatStatus showSeatStatus) {
        this.price = price;
        this.show = show;
        this.seat = seat;
        this.showSeatStatus = showSeatStatus;
    }
}
