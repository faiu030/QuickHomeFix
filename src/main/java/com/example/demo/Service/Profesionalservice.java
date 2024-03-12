package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Booking;
import com.example.demo.entity.Professional;

public interface ProfesionalService {

	int createprofessional(Professional professional);

	void professionalStatus(String email);

	

	Professional getProfessionalById(Long professionalId);

	List<Booking> listbookings(Professional professional);
	
	

}
