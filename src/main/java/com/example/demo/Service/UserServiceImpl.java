package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Bookings;
import com.example.demo.Entity.User;
import com.example.demo.Repo.bookingsrepo;
import com.example.demo.Repo.userrepo;

@Service
public class UserServiceImpl implements userservice {

    @Autowired
    userrepo r;

    @Autowired
    bookingsrepo br;

    @Autowired
    bookingService bs;

    @Override
    public int createuser(User user) {
        User existingUser = r.findByEmail(user.getEmail());
        if (existingUser == null) {
            r.save(user);
            return 1; // Created
        }
        return 0; // Already exists
    }

   

    @Override
    public List<Bookings> viewbookings(User user) {
        User existingUser = r.findByEmail(user.getEmail());
        if (existingUser != null) {
            return bs.getuserbookings(existingUser.getId());
        }
        return null; // Return null if user not found
    }

   
}
