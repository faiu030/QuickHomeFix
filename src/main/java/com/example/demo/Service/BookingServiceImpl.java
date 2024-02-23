package com.example.demo.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Bookings;
import com.example.demo.Entity.Cart;

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
            throw new RuntimeException("User not found");
        }
        
        List<Cart> cartItems = cartRepo.findByUser(foundUser);
        if(cartItems.isEmpty()) {
            throw new RuntimeException("No items in the cart");
        }
        
        try {
            for (Cart cartItem : cartItems) {
                Bookings booking = new Bookings();
                booking.setUser(cartItem.getUser());
                booking.setService(cartItem.getServices());
                booking.setBookingDateTime(LocalDateTime.now());
                booking.setScheduledDateTime(scheduledDateTime);
                booking.setPaymentstatus(0);
                booking.setServicestatus(0);
                bookingsRepository.save(booking);
            }
            
            cartRepo.deleteAll(cartItems);
            
            return "Services booked successfully";
        } catch (Exception e) {
            throw new RuntimeException("Failed to book services", e);
        }
    }

	@Override
	public Bookings getBookingById(Long id) {
		// TODO Auto-generated method stub
		return bookingsRepository.findById(id).orElse(null);
	}

	@Override
	public void saveOrUpdateBooking(Bookings booking) {
		// TODO Auto-generated method stub
		bookingsRepository.save(booking);
	}

	@Override
	public List<Bookings> getuserbookings(Long id) {
		// TODO Auto-generated method stub
		return bookingsRepository.findByUserId(id);
	}

	@Override
	public List<Bookings> getProfessionalBookins(Long id) {
		// TODO Auto-generated method stub
		return bookingsRepository.findByProfessionalId(id);
	}

	@Override
    public String servicecompleted(Long bookingId, Long professionalId) {
        Optional<Bookings> bookingOptional = bookingsRepository.findById(bookingId);
        if (bookingOptional.isPresent()) {
            Bookings booking = bookingOptional.get();
            if (booking.getProfessional() != null && booking.getProfessional().getId().equals(professionalId)) {
                booking.setServicestatus(1);
                booking.setPaymentstatus(1);
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
	        Optional<Bookings> optionalBooking = bookingsRepository.findById(bookingId);

	        if (optionalBooking.isPresent()) {
	            Bookings booking = optionalBooking.get();

	            if (userId.equals(booking.getUser().getId())) {
	                if (booking.getServicestatus() == 0) {
	                    bookingsRepository.delete(booking);
	                    return "Booking canceled successfully";
	                } else {
	                    return "Service status is not 0. Cannot cancel booking.";
	                }
	            } else {
	                return "User does not have permission to cancel this booking.";
	            }
	        } else {
	            return "Booking not found.";
	        }
	    }
	 
	
	
}
