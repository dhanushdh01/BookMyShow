package com.example.bookmyshow.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class BaseModel {
    private Long id;
    private Date createAt;
    private Date modifiedAt;
}
