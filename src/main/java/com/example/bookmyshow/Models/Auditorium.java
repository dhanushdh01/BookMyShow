package com.example.bookmyshow.Models;

import com.example.bookmyshow.Models.Constant.AuditoriumFeature;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Auditorium extends  BaseModel {
    private String name;
    private int capacity;
    private List<Show> shows;
    private List<Seat> seats;
    private List<AuditoriumFeature> auditoriumFeatures;
}
