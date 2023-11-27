package com.example.bookmyshow.Models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@Entity
public class Booking extends BaseModel{
    private User user;
    private  Show show;
    private List<ShowSeat> showSeat;
    private int amount;
    private List<Payment> payments;
    private Date bookedAt;
}
