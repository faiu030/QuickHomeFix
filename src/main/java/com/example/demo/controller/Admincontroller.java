package com.example.demo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.Admin;
import com.example.demo.Entity.Bookings;
import com.example.demo.Entity.Professional;
import com.example.demo.Entity.User;
import com.example.demo.Service.Adminservice;

@RestController
public class Admincontroller {

    @Autowired
    Adminservice s;

    @PostMapping("/verifyadmin")
    public ResponseEntity<String> verifyAdmin(@RequestBody Admin admin) {
        try {
            int result = s.verifyAdmin(admin);
            if (result == -1) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Admin does not exist");
            } else if (result == 0) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");
            } else {
                return ResponseEntity.ok("Admin login success");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
        }
    }

    @PostMapping("/createadmin")
    public ResponseEntity<String> createAdmin(@RequestBody Admin admin) {
        try {
            String response = s.createAdmin(admin);
            if (response.equals("already exist")) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Admin already exists");
            } else {
                return ResponseEntity.status(HttpStatus.CREATED).body("Admin created successfully");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
        }
    }

    @GetMapping("/listallbookings")
    public ResponseEntity<List<Bookings>> listAllBookings() {
        List<Bookings> bookings = s.listAllBookings();
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/listallprofessionals")
    public ResponseEntity<List<Professional>> listAllProfessionals() {
        List<Professional> professionals = s.listAllProfessionals();
        return ResponseEntity.ok(professionals);
    }

    @GetMapping("/listallusers")
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = s.listAllUsers();
        return ResponseEntity.ok(users);
    }

   

    @PostMapping("/assignProfessional/{bookingId}/{professionalId}")
    public ResponseEntity<String> assignProfessional(@PathVariable Long bookingId, @PathVariable Long professionalId) {
        try {
            s.assignProfessional(bookingId, professionalId);
            return ResponseEntity.ok("Professional assigned successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to assign professional: " + e.getMessage());
        }
    }
}
    


