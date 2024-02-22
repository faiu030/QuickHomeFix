package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Admin;
import com.example.demo.Entity.Bookings;
import com.example.demo.Entity.Professional;
import com.example.demo.Entity.User;

public interface Adminservice {

    int verifyAdmin(Admin admin);

    String createAdmin(Admin admin);

    List<Bookings> listAllBookings();

    List<Professional> listAllProfessionals();

    List<User> listAllUsers();

    

    void assignProfessional(Long bookingId, Long professionalId);

}
