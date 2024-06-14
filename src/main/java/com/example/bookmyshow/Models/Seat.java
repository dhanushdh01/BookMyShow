package com.example.bookmyshow.Models;

import com.example.bookmyshow.Models.Constant.SeatStatus;
import com.example.bookmyshow.Models.Constant.SeatType;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Seat  extends BaseModel {
    private int row;
    private int column;
    private String seatNumber;
    private SeatType seatType;
    private SeatStatus seatStatus;

    public Seat() {
    }

    public Seat(int row, int column, String seatNumber, SeatType seatType, SeatStatus seatStatus) {
        this.row = row;
        this.column = column;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.seatStatus = seatStatus;
    }
}
