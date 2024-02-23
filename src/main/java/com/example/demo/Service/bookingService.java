package com.example.demo.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Bookings;
import com.example.demo.Entity.Services;
import com.example.demo.Entity.User;

@Service
public interface bookingService {

	String bookservice(User user, LocalDateTime t);

	Bookings getBookingById(Long id);

	void saveOrUpdateBooking(Bookings booking);

	List<Bookings> getuserbookings(Long id);

	List<Bookings> getProfessionalBookins(Long id);

	String servicecompleted(Long bookingId, Long professionalId);

	String cancelBooking(Long userId, Long bookingId);



}
