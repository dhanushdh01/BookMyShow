package com.example.bookmyshow.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment extends BaseModel{
    private String refNo;
    private int amount;
    private PaymentProvider paymentProvider;
    private PaymentStatus paymentStatus;
}
