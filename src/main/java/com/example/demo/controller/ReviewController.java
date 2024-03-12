package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ReviewDto;
import com.example.demo.entity.Review;
import com.example.demo.service.ReviewService;

@RestController
public class ReviewController {

    @Autowired
    ReviewService rs;

    @PostMapping("/writereview/{bookingId}/{userId}")
    public ResponseEntity<String> writereview(@PathVariable Long bookingId, @PathVariable Long userId,
            @RequestBody ReviewDto dto) {
        try {
            String review = dto.getReview();
            int rating = dto.getRating();
            rs.writereview(bookingId, userId, review, rating);
            return ResponseEntity.ok("Review added successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to add review: " + e.getMessage());
        }
    }

    @GetMapping("/readreviewbyservice/{serviceId}")
    public ResponseEntity<List<Review>> readreviewbyservice(@PathVariable Long serviceId) {
 
            List<Review> reviews = rs.readreviewbyservice(serviceId);
            return ResponseEntity.ok(reviews);
       
    }
}
