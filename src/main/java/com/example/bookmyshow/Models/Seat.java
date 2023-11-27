package com.example.bookmyshow.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seat extends BaseModel{
    private String num;
    private SeatType seatType;
    private int rowVal;
    private int colVal;
}
