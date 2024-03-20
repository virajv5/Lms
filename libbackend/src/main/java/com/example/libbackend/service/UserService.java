package com.example.libbackend.service;

import com.example.libbackend.model.User;
import com.example.libbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        // Check if email is already registered
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Email is already registered");
        }

        // Save user to the database
        return userRepository.save(user);
    }

    public User getUserByEmail(String email) {
        // Fetch user by email from the database
        return userRepository.findByEmail(email);
    }
}
