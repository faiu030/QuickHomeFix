package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Bookings;
import com.example.demo.Entity.Professional;
import com.example.demo.Entity.Services;
import com.example.demo.Entity.User;
import com.example.demo.Repo.bookingsrepo;
import com.example.demo.Repo.servicesrepo;
import com.example.demo.Repo.userrepo;

@Service
public class UserServiceImpl implements userservice {

	@Autowired
	userrepo r;
	
	@Autowired
	servicesrepo rs;
	
	@Autowired
	bookingsrepo br;

	@Override
	public int createuser(User user) {
		// TODO Auto-generated method stub
		User p=r.findByEmail(user.getEmail());
		if(p == null) {
			r.save(user);
			return 1;
		}
		return 0;
	}

	@Override
	public int verifyprofessional(User user) {
		// Fetch the user by email
	    User user1 = r.findByEmail(user.getEmail());
	    
	    if(user==null || user.getEmail()==null || user.getPassword()==null) return -1;
	    // If the user with the provided email doesn't exist
	    if (user1 == null) {
	        return -1; // User does not exist
	    }

	    // Check if the password matches
	    if (user1.getPassword().equals(user.getPassword())) {
	    	return 1;//sucess
	    } else {
	        return 0; // Invalid email or password
	    }
	}

//	@Override
//	public List<Bookings> viewbookings(User user) {
//		// TODO Auto-generated method stub
//		return r.findByUser(user);
//	}

	@Override
	public String cancelbooking(User user) {
		// TODO Auto-generated method stub
		r.delete(user);
		return "canceled";
	}

	
}
