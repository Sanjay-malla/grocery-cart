package com.grocery.demo.controller;

import com.grocery.demo.model.User;
import com.grocery.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*") // Allow frontend access
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
        userService.registerUser(user);
        return "Signup successful!";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User foundUser = userService.loginUser(user.getUsername(), user.getPassword());
        return (foundUser != null) ? "Login successful!" : "Invalid username or password!";
    }

    // GET all users
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Get user details by username
    @GetMapping("/users/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username); // Fetch user by username
    }

    // ADD user
    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    // UPDATE user
    @PutMapping("/users/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        User user = userService.updateUser(id, updatedUser);
        return (user != null) ? ResponseEntity.ok("User updated") : ResponseEntity.notFound().build();
    }

    // DELETE user
    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted");
    }
}