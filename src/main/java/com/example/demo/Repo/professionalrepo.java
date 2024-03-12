package com.example.demo.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.entity.Professional;

@Repository
public interface ProfessionalRepo extends JpaRepository<Professional, Long> {

	Professional findByEmail(String email);

	//List<Bookings> findAll(Professional professional);

}
