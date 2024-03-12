package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Booking;
import com.example.demo.entity.Review;
import com.example.demo.repo.ReviewRepo;
import com.example.demo.repo.BookingRepo;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepo rr;

    @Autowired
    BookingRepo br;

    @Override
    public String writereview(Long bookingId, Long userId, String review, int rating) {
        Optional<Booking> bookingOptional = br.findById(bookingId);
        if (bookingOptional.isPresent()) {
            Booking booking = bookingOptional.get();
            // Check if the booking is related to the authenticated user
            if (booking.getUser().getId().equals(userId)) {
                // Check if the booking is completed
                if (booking.getServiceStatus() == 1) {
                    // Create a new review
                    Review reviews = new Review();
                    reviews.setUser(booking.getUser());
                    reviews.setQuickService(booking.getQuickService());
                    reviews.setProfessional(booking.getProfessional());
                    reviews.setRating(rating);
                    reviews.setReview(review);
                    // Save the review
                    rr.save(reviews);
                    return "Review added successfully.";
                } else {
                    return "Booking status is not suitable for adding review.";
                }
            } else {
                return "User is not authorized to add review for this booking.";
            }
        } else {
            return "Booking with id " + bookingId + " not found.";
        }
    }

    @Override
    public List<Review> readreviewbyservice(Long serviceId) {
        return rr.findByQuickServiceId(serviceId);
    }
}
