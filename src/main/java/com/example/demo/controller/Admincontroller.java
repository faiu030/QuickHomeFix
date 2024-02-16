package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Entity.Bookings;
import com.example.demo.Entity.Professional;
import com.example.demo.Entity.User;
import com.example.demo.Entity.Admin;

import com.example.demo.Service.Adminservice;

@RestController
public class Admincontroller {

	@Autowired
	Adminservice s;
	
	@GetMapping("/verifyadmin")
	public String verifyadmin(@RequestBody Admin admin)
	{
		int i=s.verifyadmin(admin);
		if(i==-1) return "not exist";
		if(i==0) return "invalid password";
		return " admin login success";
	}
	
	@PostMapping("/createadmin")
	public String userlogin(@RequestBody Admin admin)
	{
		return s.userlogin(admin);
	}
	@GetMapping("/listallbookings")
	public List<Bookings> listallbookings()
	{
		return s.listallbookings();
	}
//	
	@GetMapping("/listallprofessionals")
	public List<Professional> listallprofessionals()
	{
		return s.listallprofessionals();
	}
//	
	@GetMapping("/listallusers")
	public List<User> listallusers( )
	{
		return s.listallusers();
	}
//	
	@DeleteMapping("deleteuser")
	public String deleteuser(@RequestBody User user)
	{
		return s.deleteuser(user);
	}
	@DeleteMapping("deleteprofessional")
	public String deleteuser(@RequestBody Professional professional)
	{
		return s.deleteprofessional(professional);
	}
}
