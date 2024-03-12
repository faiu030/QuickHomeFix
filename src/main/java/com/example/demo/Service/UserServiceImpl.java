package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Booking;
import com.example.demo.entity.User;
import com.example.demo.repo.BookingRepo;
import com.example.demo.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    BookingService bookingService;

    @Override
    public int createuser(User user) {
        User existingUser = userRepo.findByEmail(user.getEmail());
        if (existingUser == null) {
            userRepo.save(user);
            return 1; // Created
        }
        return 0; // Already exists
    }

   

    @Override
    public List<Booking> viewbookings(User user) {
        User existingUser = userRepo.findByEmail(user.getEmail());
        if (existingUser != null) {
            return bookingService.getuserbookings(existingUser.getId());
        }
        return null; // Return null if user not found
    }

   
}
