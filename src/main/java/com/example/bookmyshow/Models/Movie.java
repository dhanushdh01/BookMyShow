package com.example.bookmyshow.Models;

import com.example.bookmyshow.Models.Constant.MovieFeature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
//TODO add more attributes
@Getter
@Setter
@Entity
public class Movie extends BaseModel{
    private String name;
    private String description;
    @ManyToMany
    private List<Actor> actors;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<MovieFeature> movieFeatures;

    public Movie() {
    }

    public Movie(String name, String description) {
        this.name = name;
        this.description = description;
    }
}