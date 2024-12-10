package com.example.backend.controller;

import com.example.backend.db_model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @PostMapping
    public User createUser(@RequestBody User user) {
        // Logic to save the user to the database
        return user;
    }
}