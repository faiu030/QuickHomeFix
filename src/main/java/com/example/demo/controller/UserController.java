package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Entity.Bookings;
import com.example.demo.Entity.User;
import com.example.demo.Service.bookingService;
import com.example.demo.Service.userservice;

@RestController
public class UserController {

    @Autowired
    userservice s;
    
    @Autowired
    bookingService bs;

    @PostMapping("/createuser")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        int result = s.createuser(user);
        if (result == 1) {
            return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
        } else if (result == 0) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid user details");
        }
    }

    

    @GetMapping("/viewbookings")
    public ResponseEntity<List<Bookings>> viewBookings(@RequestBody User user) {
        List<Bookings> bookings = s.viewbookings(user);
        return ResponseEntity.ok(bookings);
    }

    @DeleteMapping("/cancelbooking/{userId}/{bookingId}")
    public ResponseEntity<String> cancelBooking(@PathVariable Long userId, @PathVariable Long bookingId) {
        String result = bs.cancelBooking(userId, bookingId);
        
        if (result.equals("Booking canceled successfully")) {
            return ResponseEntity.ok(result);
        } else if (result.equals("Service status is not 0. Cannot cancel booking.")) {
            return ResponseEntity.badRequest().body(result);
        } else if (result.equals("User does not have permission to cancel this booking.")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
        } else if (result.equals("Booking not found.")) {
            return ResponseEntity.notFound().build(); // No body for not found response
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error canceling booking");
        }
    }
}
