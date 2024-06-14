package com.example.bookmyshow.Models;

import com.example.bookmyshow.Models.Constant.MovieFeature;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Show extends BaseModel {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Movie movie;
    private Auditorium auditorium;
    private List<ShowSeat> showSeats;
    private List<MovieFeature> movieFeatures;
}
