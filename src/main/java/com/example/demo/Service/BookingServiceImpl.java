package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Booking;
import com.example.demo.entity.Cart;
import com.example.demo.entity.User;
import com.example.demo.repo.CartRepo;
import com.example.demo.repo.BookingRepo;
import com.example.demo.repo.UserRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepo bookingsRepository;
    
    @Autowired
    private CartRepo cartRepo;
    
    @Autowired
    private UserRepo userRepository;

    @Override
    public String bookservice(User user, LocalDateTime scheduledDateTime) {
        User foundUser = userRepository.findByEmail(user.getEmail());
        if (foundUser == null) {
            throw new RuntimeException("User not found");
        }
        
        List<Cart> cartItems = cartRepo.findByUser(foundUser);
        if(cartItems.isEmpty()) {
            throw new RuntimeException("No items in the cart");
        }
        
        try {
            for (Cart cartItem : cartItems) {
                Booking booking = new Booking();
                booking.setUser(cartItem.getUser());
                booking.setQuickService(cartItem.getService());
                booking.setBookingDateTime(LocalDateTime.now());
                booking.setScheduledDateTime(scheduledDateTime);
                booking.setPaymentStatus(0);
                booking.setServiceStatus(0);
                bookingsRepository.save(booking);
            }
            
            cartRepo.deleteAll(cartItems);
            
            return "Services booked successfully";
        } catch (Exception e) {
            throw new RuntimeException("Failed to book services", e);
        }
    }

	@Override
	public Booking getBookingById(Long id) {
		// TODO Auto-generated method stub
		return bookingsRepository.findById(id).orElse(null);
	}

	@Override
	public void saveOrUpdateBooking(Booking booking) {
		// TODO Auto-generated method stub
		bookingsRepository.save(booking);
	}

	@Override
	public List<Booking> getuserbookings(Long id) {
		// TODO Auto-generated method stub
		return bookingsRepository.findByUserId(id);
	}

	@Override
	public List<Booking> getProfessionalBookins(Long id) {
		// TODO Auto-generated method stub
		return bookingsRepository.findByProfessionalId(id);
	}

	@Override
    public String servicecompleted(Long bookingId, Long professionalId) {
        Optional<Booking> bookingOptional = bookingsRepository.findById(bookingId);
        if (bookingOptional.isPresent()) {
            Booking booking = bookingOptional.get();
            if (booking.getProfessional() != null && booking.getProfessional().getId().equals(professionalId)) {
                booking.setServiceStatus(1);
                booking.setPaymentStatus(1);
                bookingsRepository.save(booking);
                return "Service completed successfully for bookingId: " + bookingId;
            } else {
            	return "Professional not found";
            }
        } else {
            return "service not found";
        }
    }

	 @Override
	    public String cancelBooking(Long userId, Long bookingId) {
	        Optional<Booking> optionalBooking = bookingsRepository.findById(bookingId);

	        if (optionalBooking.isPresent()) {
	            Booking booking = optionalBooking.get();

	            if (userId.equals(booking.getUser().getId())) {
	                if (booking.getServiceStatus() == 0) {
	                    bookingsRepository.delete(booking);
	                    return "Booking canceled successfully";
	                } else {
	                    return "Service status is completed.Cannot cancel booking.";
	                }
	            } else {
	                return "User does not have permission to cancel this booking.";
	            }
	        } else {
	            return "Booking not found.";
	        }
	    }
	 
	
	
}
