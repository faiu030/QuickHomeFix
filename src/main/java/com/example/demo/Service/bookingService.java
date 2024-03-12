package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;


import org.springframework.stereotype.Service;

import com.example.demo.entity.Booking;

import com.example.demo.entity.User;

@Service
public interface BookingService {

	String bookservice(User user, LocalDateTime t);

	Booking getBookingById(Long id);

	void saveOrUpdateBooking(Booking booking);

	List<Booking> getuserbookings(Long id);

	List<Booking> getProfessionalBookins(Long id);

	String servicecompleted(Long bookingId, Long professionalId);

	String cancelBooking(Long userId, Long bookingId);



}
