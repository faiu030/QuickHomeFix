package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Booking;
import com.example.demo.entity.Professional;
import com.example.demo.repo.ProfessionalRepo;
import com.example.demo.service.ProfesionalService;
import com.example.demo.service.BookingService;

@RestController

public class ProffesionalController {

    @Autowired
    ProfesionalService profesionalService;

    @Autowired
    BookingService bookingService;
    
    @Autowired
    ProfessionalRepo professionalRepo;

    @PostMapping("/createprofessional")
    public ResponseEntity<String> createProfessional(@RequestBody Professional professional) {
        int result = profesionalService.createprofessional(professional);
        if (result == 1) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Account created successfully");
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Account already exists");
        }
    }

    
    @PutMapping("/professionalstatus/{email}")
    public ResponseEntity<String> professionalStatus(@PathVariable String email) {
        try {
            profesionalService.professionalStatus(email);
            Professional professional = professionalRepo.findByEmail(email);
            String statusMessage = (professional.getStatus() == 0) ? "You are offline now" : "You are online now";
            return ResponseEntity.ok(statusMessage);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating professional status");
        }
    }



    @GetMapping("/professional/listbookings")
    public ResponseEntity<List<Booking>> listBookings(@RequestBody Professional professional) {
        List<Booking> bookings = profesionalService.listbookings(professional);
        return ResponseEntity.ok(bookings);
    }

    @PutMapping("/servicecompleted/{bookingId}/{professionalId}")
    public ResponseEntity<String> serviceCompleted(@PathVariable Long bookingId, @PathVariable Long professionalId) {
        try {
            String result = bookingService.servicecompleted(bookingId, professionalId);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }
}
