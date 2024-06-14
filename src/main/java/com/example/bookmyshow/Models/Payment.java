package com.example.bookmyshow.Models;

import com.example.bookmyshow.Models.Constant.PaymentMode;
import com.example.bookmyshow.Models.Constant.PaymentStatus;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter

public class Payment extends BaseModel {
    private LocalDateTime paymentTime;
    private double amount;
    private String transactionId;
    private Ticket ticket;
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;
}
