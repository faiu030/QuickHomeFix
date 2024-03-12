package com.example.demo.controller;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.User;
import com.example.demo.service.BookingService;

@RestController
public class BookingContoller {

    @Autowired
    BookingService bookingService;
    
    @PostMapping("/bookservice/{useremail}/{scheduledDateTime}")
    public ResponseEntity<String> bookService(
            @PathVariable("useremail") String email, 
            @PathVariable("scheduledDateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime scheduledDateTime) {
        
        User user = new User();
        user.setEmail(email);
        
        try {
            String result = bookingService.bookservice(user, scheduledDateTime);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to book service: " + e.getMessage());
        }
    }

}
