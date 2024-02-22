package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Entity.Professional;
import com.example.demo.Entity.Bookings;
import com.example.demo.Service.Profesionalservice;
import com.example.demo.Service.bookingService;

@RestController

public class ProffesionalController {

    @Autowired
    Profesionalservice professionalservice;

    @Autowired
    bookingService bs;

    @PostMapping("/createprofessional")
    public ResponseEntity<String> createProfessional(@RequestBody Professional professional) {
        int result = professionalservice.createprofessional(professional);
        if (result == 1) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Account created successfully");
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Account already exists");
        }
    }

    @PostMapping("/verifyprofessional")
    public ResponseEntity<String> verifyProfessional(@RequestBody Professional professional) {
        int result = professionalservice.verifyprofessional(professional);
        if (result == 1) {
            return ResponseEntity.status(HttpStatus.OK).body("Login success");
        } else if (result == 0) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Professional does not exist");
        }
    }

    @PutMapping("/professionalstatus")
    public ResponseEntity<Void> professionalStatus(@RequestBody Professional professional) {
        professionalservice.professionalStatus(professional);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/professional/listbookings")
    public ResponseEntity<List<Bookings>> listBookings(@RequestBody Professional professional) {
        List<Bookings> bookings = professionalservice.listbookings(professional);
        return ResponseEntity.ok(bookings);
    }

    @PutMapping("/servicecompleted/{bookingId}/{professionalId}")
    public ResponseEntity<String> serviceCompleted(@PathVariable Long bookingId, @PathVariable Long professionalId) {
        try {
            String result = bs.servicecompleted(bookingId, professionalId);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }
}
