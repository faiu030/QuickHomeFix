package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Booking;

import com.example.demo.entity.User;

public interface UserService {

	int createuser(User user);

	

	List<Booking> viewbookings(User user);

	

	

}
