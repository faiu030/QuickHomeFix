package com.example.demo.service;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Booking;
import com.example.demo.entity.Professional;
import com.example.demo.repo.BookingRepo;
import com.example.demo.repo.ProfessionalRepo;

@Service
public class ProfessionalServiceImpl implements ProfesionalService {
    
    @Autowired
    ProfessionalRepo professionalRepo;
    
    @Autowired
    BookingRepo bookingRepo;
    
    @Autowired
    BookingService bookingService;

    @Override
    public int createprofessional(Professional professional) {
        Professional p = professionalRepo.findByEmail(professional.getEmail());
        if (p == null) {
            professionalRepo.save(professional);
            return 1; // Created
        }
        return 0; // Already exists
    }

   

   

    @Override
    public Professional getProfessionalById(Long professionalId) {
        return professionalRepo.findById(professionalId).orElse(null);
    }

    @Override
    public List<Booking> listbookings(Professional professional) {
        Professional p = professionalRepo.findByEmail(professional.getEmail());
        return bookingService.getProfessionalBookins(p.getId());
    }





	@Override
	public void professionalStatus(String email) {
		// TODO Auto-generated method stub
		Professional p = professionalRepo.findByEmail(email);
	    if (p != null) {
	        int status = (p.getStatus() == 0) ? 1 : 0;
	        p.setStatus(status);
	        professionalRepo.save(p);
	    } else {
	        throw new RuntimeException("Professional with email " + email + " not found");
	    }
	}
}