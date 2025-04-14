package com.grocery.demo.service;

import com.grocery.demo.model.User;
import com.grocery.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Signup
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    // Login
    public User loginUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;  // Login success
        }
        return null;  // Login failed
    }

    // Fetch User Details by Username
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);  // Fetch user based on username
    }

    // Admin Panel: View All Users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Admin Panel: Update User
    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setUsername(updatedUser.getUsername());
            user.setPassword(updatedUser.getPassword());
            user.setCategory(updatedUser.getCategory()); // Update category as well
            return userRepository.save(user);
        }).orElse(null);
    }

    // Admin Panel: Delete User
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}