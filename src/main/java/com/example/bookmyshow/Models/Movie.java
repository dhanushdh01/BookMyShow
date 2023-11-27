package com.example.bookmyshow.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Movie extends  BaseModel{
    private String name;
    private String Cast;
    private  String Des;
    private List<Feature> features;
}
