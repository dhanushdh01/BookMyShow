package com.example.bookmyshow.Models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public abstract class BaseModel {
    private int id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean isDeleted;
    private String createdBy;
    private String updatedBy;
}
