package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Booking;
import com.example.demo.entity.Professional;
import com.example.demo.entity.User;
import com.example.demo.repo.AdminRepo;
import com.example.demo.repo.BookingRepo;
import com.example.demo.repo.ProfessionalRepo;
import com.example.demo.repo.UserRepo;


@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepo adminRepo;

    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    ProfessionalRepo professionalRepo;

    @Autowired
    UserRepo userRepo;

   

    @Override
    public String createAdmin(Admin admin) {
        if (adminRepo.findByEmail(admin.getEmail()) == null) {
            adminRepo.save(admin);
            return "admin created";
        }
        return "already exist";
    }

    @Override
    public List<Booking> listAllBookings() {
        return bookingRepo.findAll();
    }

    @Override
    public List<Professional> listAllProfessionals() {
        return professionalRepo.findAll();
    }

    @Override
    public List<User> listAllUsers() {
        return userRepo.findAll();
    }

   
    @Override
    public void assignProfessional(Long bookingId, Long professionalId) {
        Booking booking = bookingRepo.findById(bookingId).orElse(null);
        Professional professional = professionalRepo.findById(professionalId).orElse(null);

        if (booking != null && professional != null && booking.getServiceStatus() == 0 && professional.getStatus() == 1) {
            booking.setProfessional(professional);
            bookingRepo.save(booking);
        } else {
            throw new RuntimeException("Invalid booking or professional details or professional status is not available at the moment");
        }}

}
