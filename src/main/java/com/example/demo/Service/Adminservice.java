package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Booking;
import com.example.demo.entity.Professional;
import com.example.demo.entity.User;

public interface AdminService {

    

    String createAdmin(Admin admin);

    List<Booking> listAllBookings();

    List<Professional> listAllProfessionals();

    List<User> listAllUsers();

    

    void assignProfessional(Long bookingId, Long professionalId);

}
