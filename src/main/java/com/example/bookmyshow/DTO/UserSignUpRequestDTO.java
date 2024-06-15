package com.example.bookmyshow.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignUpRequestDTO {
    private String name;
    private String email;
    private String password;;
    private String contact;
}
