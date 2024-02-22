package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Admin;
import com.example.demo.Entity.Bookings;
import com.example.demo.Entity.Professional;
import com.example.demo.Entity.User;
import com.example.demo.Repo.AdminRepo;
import com.example.demo.Repo.bookingsrepo;
import com.example.demo.Repo.professionalrepo;
import com.example.demo.Repo.userrepo;


@Service
public class AdminserviceImpl implements Adminservice {

    @Autowired
    AdminRepo ar;

    @Autowired
    bookingsrepo br;

    @Autowired
    professionalrepo pr;

    @Autowired
    userrepo ur;

    @Override
    public int verifyAdmin(Admin admin) {
        Admin a = ar.findByEmail(admin.getEmail());
        if (admin.getEmail() == null || admin.getPassword() == null)
            return -1;
        if (a == null)
            return -1;
        if (a.getEmail().equals(admin.getEmail()) && a.getPassword().equals(admin.getPassword()))
            return 1;
        return -1;
    }

    @Override
    public String createAdmin(Admin admin) {
        if (ar.findByEmail(admin.getEmail()) == null) {
            ar.save(admin);
            return "admin created";
        }
        return "already exist";
    }

    @Override
    public List<Bookings> listAllBookings() {
        return br.findAll();
    }

    @Override
    public List<Professional> listAllProfessionals() {
        return pr.findAll();
    }

    @Override
    public List<User> listAllUsers() {
        return ur.findAll();
    }

   
    @Override
    public void assignProfessional(Long bookingId, Long professionalId) {
        Bookings booking = br.findById(bookingId).orElse(null);
        Professional professional = pr.findById(professionalId).orElse(null);

        if (booking != null && professional != null && booking.getServicestatus() == 0 && professional.getStatus() == 1) {
            booking.setProfessional(professional);
            br.save(booking);
        }
    }

}
