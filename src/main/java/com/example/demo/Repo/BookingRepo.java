package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Booking;

import java.util.List;

public interface BookingRepo extends JpaRepository<Booking, Long> {

    List<Booking> findByUserId(Long userId);

    List<Booking> findByProfessionalId(Long professionalId);

    Long findBookingIdByUserIdAndQuickServiceId(Long userId, Long quickServiceId);
}
