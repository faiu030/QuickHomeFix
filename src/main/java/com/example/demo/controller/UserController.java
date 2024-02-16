package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Bookings;
import com.example.demo.Entity.Services;
import com.example.demo.Entity.User;
import com.example.demo.Service.userservice;

@RestController
public class UserController {

	@Autowired
	userservice s;
	
	//create user
	@PostMapping("/createuser")
	public String createuser(@RequestBody User user)
	{
		int i=s.createuser(user);
		if(i==1) return "account created";
		return "already exist";
		
	}
	
	
	//verify user
	@GetMapping("/verifyuser")
	public String verifyuser(@RequestBody User user)
	{
		int i=s.verifyprofessional(user);
		if(i==-1) return "not exist";
		if(i==0) return "invalid password";
		return " user login success";
	}
	
//	//view bookings
//	@GetMapping("/viewbookings")
//	public List<Bookings> viewbookings(@RequestBody User user)
//	{
//		return s.viewbookings(user);
//	}
	
	
	//cancel bookings 
	@DeleteMapping("/cancelbooking")
	public String cancelbooking(@RequestBody User user)
	{
		return s.cancelbooking(user);
	}
	

	
}
