package com.grocery.demo.repository;

import com.grocery.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username); // Already exists, no changes required
}