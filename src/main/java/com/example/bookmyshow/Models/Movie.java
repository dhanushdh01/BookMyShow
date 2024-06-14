package com.example.bookmyshow.Models;

import com.example.bookmyshow.Models.Constant.MovieFeature;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class Movie extends BaseModel {
    private String name;
    private String description;
    private String language;
    private int duration;
    private String genre;
    private String director;
    private String producer;
    private String writer;
    private String musicDirector;
    private String productionHouse;
    private String trailerUrl;
    private String posterUrl;
    private String releaseDate;
    private String status;
    private String certification;
    private String imdbRating;
    private List<Actor> actors;
    private List<MovieFeature> movieFeatures;

    public Movie() {
    }

    public Movie(String name, String description, String language, int duration, String genre, String director, String producer, String writer, String musicDirector, String productionHouse, String trailerUrl, String posterUrl, String releaseDate, String status, String certification, String imdbRating) {
        this.name = name;
        this.description = description;
        this.language = language;
        this.duration = duration;
        this.genre = genre;
        this.director = director;
        this.producer = producer;
        this.writer = writer;
        this.musicDirector = musicDirector;
        this.productionHouse = productionHouse;
        this.trailerUrl = trailerUrl;
        this.posterUrl = posterUrl;
        this.releaseDate = releaseDate;
        this.status = status;
        this.certification = certification;
        this.imdbRating = imdbRating;
    }
}
