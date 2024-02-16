package com.example.demo.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Bookings;
import com.example.demo.Entity.Cart;
import com.example.demo.Entity.Services;
import com.example.demo.Entity.User;
import com.example.demo.Repo.CartRepo;
import com.example.demo.Repo.bookingsrepo;
import com.example.demo.Repo.userrepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookingServiceImpl implements bookingService {

    @Autowired
    private bookingsrepo bookingsRepository;
    
    @Autowired
    private CartRepo cartRepo;
    
    @Autowired
    private userrepo userRepository;

    @Override
    public String bookservice(User user, LocalDateTime scheduledDateTime) {
        User foundUser = userRepository.findByEmail(user.getEmail());
        if (foundUser == null) {
            return "User not found";
        }
        
        // Fetch cart items for the user
        List<Cart> cartItems = cartRepo.findByUser(foundUser);
        
        if(cartItems.isEmpty()) {
            return "No item in cart";
        }
        
        try {
            // Process each cart item and create a booking
            for (Cart cartItem : cartItems) {
                Bookings booking = new Bookings();
                booking.setUser(cartItem.getUser());
                booking.setService(cartItem.getServices());
                booking.setBookingDateTime(LocalDateTime.now());
                booking.setScheduledDateTime(scheduledDateTime);
                booking.setPaymentstatus(0);
                // Save the booking
                bookingsRepository.save(booking);
            }
            
            // Remove cart items after successful booking
            cartRepo.deleteAll(cartItems);
            
            return "Services booked successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to book services";
        }
    }
}
