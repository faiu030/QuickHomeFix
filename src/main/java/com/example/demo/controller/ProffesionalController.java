package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Professional;
import com.example.demo.Service.Profesionalservice;
import com.example.demo.Entity.Bookings;

@RestController
public class ProffesionalController {

	@Autowired
	Profesionalservice professionalservice;
	
	@PostMapping("/createprofessional")
	public String createprofessional(@RequestBody Professional professional)
	{
		int i=professionalservice.createprofessional(professional);
		if(i==1) return "account created";
		return "already exist";
		
	}
	
	@GetMapping("/verify")
	public String verifyprofessional(@RequestBody Professional professional)
	{
		int i=professionalservice.verifyprofessional(professional);
		if(i==-1) return "not exist";
		if(i==0) return "invalid password";
		return "login success";
	}
	
	@PutMapping("/status")
	public void professionalStatus(@RequestBody Professional professional)
	{
		professionalservice.professionalStatus(professional);
		
	}
	
//	@GetMapping("/plistbookings")
//	public List<Bookings> listbooking(@RequestBody Professional professional){
//		return professionalservice.listbookings(professional);
//	}

}
