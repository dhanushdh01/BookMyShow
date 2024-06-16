package com.example.bookmyshow.Controller;

import com.example.bookmyshow.DTO.UserLoginRequestDTO;
import com.example.bookmyshow.DTO.UserSignUpRequestDTO;
import com.example.bookmyshow.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody UserSignUpRequestDTO requestDto) throws Exception {
        //validate the userdata
        return ResponseEntity.ok(
                userService.signUp(requestDto.getName(), requestDto.getEmail(), requestDto.getPassword())
        );
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserLoginRequestDTO requestDto) throws Exception {
        //validate the userdata
        return ResponseEntity.ok(
                userService.login( requestDto.getEmail(), requestDto.getPassword())
        );
    }
}