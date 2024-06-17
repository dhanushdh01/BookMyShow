package com.example.bookmyshow.Models;

import com.example.bookmyshow.Models.Constant.MovieFeature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends BaseModel {
    private String name;
    private String description;
    private LocalDate releaseDate;
    private int duration; // duration in minutes
    private String language;
    private String genre;
    private double rating;

    @ManyToMany
    private List<Actor> actors;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<MovieFeature> movieFeatures;

    // Default constructor
    public Movie() {
    }

    // Constructor with name and description
    public Movie(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Constructor with all attributes
    public Movie(String name, String description, LocalDate releaseDate, int duration, String language, String genre, double rating, List<Actor> actors, List<MovieFeature> movieFeatures) {
        this.name = name;
        this.description = description;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.language = language;
        this.genre = genre;
        this.rating = rating;
        this.actors = actors;
        this.movieFeatures = movieFeatures;
    }
}