package com.grocery.demo.controller;

import com.grocery.demo.model.Order;
import com.grocery.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")  // Allow frontend access
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;
o
    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        try {
            // Save the order to the database
            Order savedOrder = orderRepository.save(order);

            // Return a success message with the saved order
            return ResponseEntity.ok(savedOrder);  // Send back the saved order as response
        } catch (Exception e) {
            // Handle any errors during order placement
            return ResponseEntity.status(500).body(null);
        }
    }
}