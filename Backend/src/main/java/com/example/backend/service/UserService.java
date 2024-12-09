package com.example.backend.service;

import com.example.backend.db_model.User;
import com.example.backend.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Add a new user (refactored from CLI addUser)
    public User addUser(User user) {
        return userRepository.save(user);
    }

    // Get all users (refactored from CLI viewUsers)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
}
