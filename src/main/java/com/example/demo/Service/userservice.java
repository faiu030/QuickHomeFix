package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Bookings;
import com.example.demo.Entity.Services;
import com.example.demo.Entity.User;

public interface userservice {

	int createuser(User user);

	int verifyuser(User user);

	List<Bookings> viewbookings(User user);

	String cancelbooking(User user);

	

}
