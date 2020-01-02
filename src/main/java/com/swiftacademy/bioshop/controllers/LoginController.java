package com.swiftacademy.bioshop.controllers;


import com.swiftacademy.bioshop.DTO.UserLoginDto;
import com.swiftacademy.bioshop.model.User;
import com.swiftacademy.bioshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    private User login(@RequestBody UserLoginDto userLoginDto) {
        return userRepository.findByUserEmailAndPassword(userLoginDto.getEmail(), userLoginDto.getPassword());
    }
}
