package com.example.bookmyshow.Models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Theatre extends BaseModel {
    private String name;
    private String address;
    private City city;

    public Theatre() {
    }

    public Theatre(String name, String address, City city) {
        this.name = name;
        this.address = address;
        this.city = city;
    }
}
