package com.example.bookmyshow.Controller;

import com.example.bookmyshow.DTO.UserLoginRequestDTO;
import com.example.bookmyshow.DTO.UserSignUpRequestDTO;
import com.example.bookmyshow.Models.User;
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
    public ResponseEntity signUp(@RequestBody UserSignUpRequestDTO requestDTO) throws Exception {
        User savedUser = userService.signUp(
                requestDTO.getName(),
                requestDTO.getEmail(),
                requestDTO.getPassword()
        );
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserLoginRequestDTO requestDTO) throws Exception {
        User savedUser = userService.login(
                requestDTO.getEmail(),
                requestDTO.getPassword()
        );
        return ResponseEntity.ok(savedUser);
    }
}
