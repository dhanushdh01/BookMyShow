package com.example.bookmyshow.Models;

import com.example.bookmyshow.Models.Constant.TicketStatus;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Ticket extends BaseModel {
    private LocalDateTime bookingTime;
    private double totalPrice;
    private Show show;
    private User user;
    private Payment payment;
    private List<ShowSeat> showSeats;
    private TicketStatus ticketStatus;
}
