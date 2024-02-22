package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Bookings;
import com.example.demo.Entity.Reviews;
import com.example.demo.Repo.Reviewsrepo;
import com.example.demo.Repo.bookingsrepo;

@Service
public class ReviesServiceImpl implements ReviesService {

    @Autowired
    Reviewsrepo rr;

    @Autowired
    bookingsrepo br;

    @Override
    public String writereview(Long bookingId, Long userId, String review, int rating) {
        Optional<Bookings> bookingOptional = br.findById(bookingId);
        if (bookingOptional.isPresent()) {
            Bookings booking = bookingOptional.get();
            // Check if the booking is related to the authenticated user
            if (booking.getUser().getId().equals(userId)) {
                // Check if the booking is completed
                if (booking.getServicestatus() == 1) {
                    // Create a new review
                    Reviews reviews = new Reviews();
                    reviews.setUser(booking.getUser());
                    reviews.setServices(booking.getService());
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
    public List<Reviews> readreviewbyservice(Long serviceId) {
        return rr.findByServicesId(serviceId);
    }
}
