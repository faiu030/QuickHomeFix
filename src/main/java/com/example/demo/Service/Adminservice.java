package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Admin;
import com.example.demo.Entity.Bookings;
import com.example.demo.Entity.Professional;
import com.example.demo.Entity.User;


public interface Adminservice {

	int verifyadmin(Admin admin);

	String userlogin(Admin admin);

    List<Bookings> listallbookings();
//
	List<Professional> listallprofessionals();
//
	List<User> listallusers( );

	String deleteuser(User user);
//
	String deleteprofessional(Professional professional);

}
