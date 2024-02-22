package com.example.demo.Service;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Bookings;
import com.example.demo.Entity.Professional;
import com.example.demo.Repo.professionalrepo;
import com.example.demo.Repo.bookingsrepo;

@Service
public class ProfessionalServiceImpl implements Profesionalservice {
    
    @Autowired
    professionalrepo prepo;
    
    @Autowired
    bookingsrepo br;
    
    @Autowired
    bookingService bs;

    @Override
    public int createprofessional(Professional professional) {
        Professional p = prepo.findByEmail(professional.getEmail());
        if (p == null) {
            prepo.save(professional);
            return 1; // Created
        }
        return 0; // Already exists
    }

    @Override
    public void professionalStatus(Professional professional) {
        Professional p = prepo.findByEmail(professional.getEmail());
        int status = (p.getStatus() == 0) ? 1 : 0;
        p.setStatus(status);
        prepo.save(p);
    }

    @Override
    public int verifyprofessional(Professional professional) {
        Professional user1 = prepo.findByEmail(professional.getEmail());
        if (professional == null || professional.getEmail() == null || professional.getPassword() == null) {
            return -1; // Not found
        }
        if (user1 == null) {
            return -1; // Not found
        }
        if (user1.getPassword().equals(professional.getPassword())) {
            return 1; // Success
        } else {
            return 0; // Invalid password
        }
    }

    @Override
    public Professional getProfessionalById(Long professionalId) {
        return prepo.findById(professionalId).orElse(null);
    }

    @Override
    public List<Bookings> listbookings(Professional professional) {
        Professional p = prepo.findByEmail(professional.getEmail());
        return bs.getProfessionalBookins(p.getId());
    }
}