package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Bookings;
import com.example.demo.Entity.Professional;

@Repository
public interface professionalrepo extends JpaRepository<Professional, Long> {

	Professional findByEmail(String email);

	//List<Bookings> findAll(Professional professional);

}
