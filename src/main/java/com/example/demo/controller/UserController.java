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
import com.example.demo.Service.userservice;

@RestController
public class UserController {

    @Autowired
    userservice s;

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

    @PostMapping("/verifyuser")
    public ResponseEntity<String> verifyUser(@RequestBody User user) {
        int result = s.verifyuser(user);
        if (result == 1) {
            return ResponseEntity.status(HttpStatus.OK).body("User login success");
        } else if (result == 0) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User does not exist");
        }
    }

    @GetMapping("/viewbookings")
    public ResponseEntity<List<Bookings>> viewBookings(@RequestBody User user) {
        List<Bookings> bookings = s.viewbookings(user);
        return ResponseEntity.ok(bookings);
    }

    @DeleteMapping("/cancelbooking")
    public ResponseEntity<String> cancelBooking(@RequestBody User user) {
        String result = s.cancelbooking(user);
        if (result.equals("canceled")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error canceling booking");
        }
    }
}
