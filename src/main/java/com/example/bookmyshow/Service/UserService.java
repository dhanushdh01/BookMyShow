package com.example.bookmyshow.Service;

import com.example.bookmyshow.Models.User;
import com.example.bookmyshow.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User login(String email, String password) throws Exception {
        User user = userRepository.findByUserEmail(email);
        if(user == null){
            throw new Exception("User not found with this Mail ID");
        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if(!bCryptPasswordEncoder.matches(password,user.getPassword())){
            throw new Exception("Invalid Password");
        }
        return user;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public User signUp(String name,String email,String password) throws Exception {
        User savedUser = userRepository.findByUserEmail(email);
        if(savedUser != null){
            throw new Exception("User already exists with this Mail ID");
        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setTickets(null);
        return userRepository.save(user);
    }
}
