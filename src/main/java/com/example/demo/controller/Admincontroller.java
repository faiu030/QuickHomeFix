package com.example.demo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Booking;
import com.example.demo.entity.Professional;
import com.example.demo.entity.User;
import com.example.demo.repo.AdminRepo;
import com.example.demo.repo.ProfessionalRepo;
import com.example.demo.repo.UserRepo;
import com.example.demo.service.AdminService;
import com.example.demo.service.ProfesionalService;
import com.example.demo.service.UserService;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;
    
    @Autowired
    ProfesionalService profesionalService;

    @Autowired
    UserService userService;
    
    @Autowired
    AdminRepo adminRepository;
    
    @Autowired
    ProfessionalRepo professionalRepository;
    
    @Autowired
    UserRepo UserRepository;
    
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

    @PostMapping("/admin")
    public ResponseEntity<String> createAdmin(@RequestBody Admin admin) {
        try {
            String response = adminService.createAdmin(admin);
            if (response.equals("already exist")) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Admin already exists");
            } else {
                return ResponseEntity.status(HttpStatus.CREATED).body("Admin created successfully");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
        }
    }

    @GetMapping("/bookings")
    public ResponseEntity<List<Booking>> listAllBookings() {
        List<Booking> bookings = adminService.listAllBookings();
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/professionals")
    public ResponseEntity<List<Professional>> listAllProfessionals() {
        List<Professional> professionals = adminService.listAllProfessionals();
        return ResponseEntity.ok(professionals);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = adminService.listAllUsers();
        return ResponseEntity.ok(users);
    }

   

    @PostMapping("/assignProfessional/{bookingId}/{professionalId}")
    public ResponseEntity<String> assignProfessional(@PathVariable Long bookingId, @PathVariable Long professionalId) {
        try {
            adminService.assignProfessional(bookingId, professionalId);
            return ResponseEntity.ok("Professional assigned successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to assign professional: " + e.getMessage());
        }
    }
}
    


