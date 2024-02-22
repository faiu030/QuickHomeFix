package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Bookings;
import java.util.List;


public interface bookingsrepo extends JpaRepository<Bookings, Long >{

	List<Bookings> findByUserId(Long id);

	List<Bookings> findByProfessionalId(Long id);

	Long findBookingIdByUserIdAndServiceId(Long userId, Long serviceId);

	

}
