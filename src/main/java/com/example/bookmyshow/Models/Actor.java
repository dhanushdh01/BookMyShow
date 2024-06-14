package com.example.bookmyshow.Models;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Actor extends BaseModel {
    private String name;
    private List<Movie> movies;
}
