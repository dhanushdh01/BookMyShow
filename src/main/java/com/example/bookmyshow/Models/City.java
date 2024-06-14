package com.example.bookmyshow.Models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class City extends BaseModel {
    public City() {

    }
    public City(String name, String state, String country) {
        this.name = name;
        this.state = state;
        this.country = country;
    }
    private String name;
    private String state;
    private String country;

    private List<Theatre> theatres;
}
