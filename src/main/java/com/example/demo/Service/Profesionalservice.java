package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Bookings;
import com.example.demo.Entity.Professional;

public interface Profesionalservice {

	int createprofessional(Professional professional);

	void professionalStatus(Professional professional);

	int verifyprofessional(Professional professional);

	//List<Bookings> listbookings(Professional professional);
	
	

}
