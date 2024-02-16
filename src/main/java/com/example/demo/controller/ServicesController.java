package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Services;
import com.example.demo.Service.servicesservice;

@RestController
public class ServicesController {

	@Autowired
	servicesservice s;
	
	@PostMapping("/addservice")
    public Services addService(@RequestBody Services service) {
      return s.addservice(service);
    }
	
	@PutMapping("/update")
	public void updateService(@RequestBody Services serviceDetails) {
		
		s.updateservice(serviceDetails);
	}
	
	@GetMapping("/list")
	public List<Services> listingservices()
	{
		return s.listingservices();
	}
	
	@DeleteMapping("/delete")
	public void deleteservices(@RequestBody Services servicedetails)
	{
		s.deleteservices(servicedetails);
	}
}
