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
import com.example.demo.Repo.AdminRepo;
import com.example.demo.Repo.professionalrepo;
import com.example.demo.Repo.userrepo;
import com.example.demo.Service.Adminservice;
import com.example.demo.Service.Profesionalservice;
import com.example.demo.Service.userservice;

@RestController
public class Admincontroller {

    @Autowired
    Adminservice s;
    
    @Autowired
    Profesionalservice ps;

    @Autowired
    userservice us;
    
    @Autowired
    AdminRepo adminRepository;
    
    @Autowired
    professionalrepo professionalRepository;
    
    @Autowired
    userrepo UserRepository;
    
    @PostMapping("/verify")
    public ResponseEntity<String> verifyUser(@RequestBody User user) {
        if (user.getEmail() == null || user.getPassword() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid user data");
        }

        Admin admin = adminRepository.findByEmail(user.getEmail());
        if (admin != null && admin.getPassword().equals(user.getPassword())) {
            return ResponseEntity.status(HttpStatus.OK).body("Admin login success");
        }

        Professional professional = professionalRepository.findByEmail(user.getEmail());
        if (professional != null && professional.getPassword().equals(user.getPassword())) {
            return ResponseEntity.status(HttpStatus.OK).body("Professional login success");
        }

        User regularUser = UserRepository.findByEmail(user.getEmail());
        if (regularUser != null && regularUser.getPassword().equals(user.getPassword())) {
            return ResponseEntity.status(HttpStatus.OK).body("Regular user login success");
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
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
    


