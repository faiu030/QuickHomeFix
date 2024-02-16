package com.example.demo.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.User;
import com.example.demo.Service.bookingService;

@RestController
public class BookingContoller {

    @Autowired
    bookingService bs;
    
    @PostMapping("/bookservice/{email}/{scheduledDateTime}")
    public String bookservice(
            @PathVariable("email") String email, 
            @PathVariable("scheduledDateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime scheduledDateTime) {
        
        User user = new User();
        user.setEmail(email);
        
        return bs.bookservice(user, scheduledDateTime);
    }

}
