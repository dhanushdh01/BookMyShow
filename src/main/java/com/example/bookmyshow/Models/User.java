package com.example.bookmyshow.Models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "BMS_USER")
@Getter
@Setter
public class User extends BaseModel {
    private String name;
    private String email;
    private String password;
    private String mobileNumber;
    private List<Ticket> tickets;
}

