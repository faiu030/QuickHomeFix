package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Bookings;
import com.example.demo.Entity.Professional;
import com.example.demo.Repo.professionalrepo;


@Service
public class ProfessionalServiceImpl implements Profesionalservice {
	
	@Autowired
	professionalrepo prepo;

	@Override
	public int createprofessional(Professional professional) {
		// TODO Auto-generated method stub
		Professional p=prepo.findByEmail(professional.getEmail());
		if(p == null) {
			prepo.save(professional);
			return 1;
		}
		return 0;
	}

	@Override
	public void professionalStatus(Professional professional) {
		// TODO Auto-generated method stub
		Professional p=prepo.findByEmail(professional.getEmail());
		int status=(p.getStatus()==0)?1:0;
		p.setStatus(status);
		prepo.save(p);
	}

	@Override
	public int verifyprofessional(Professional professional) {
		// TODO Auto-generated method stub
		// Fetch the user by email
	    Professional user1 = prepo.findByEmail(professional.getEmail());
	    
	    if(professional==null || professional.getEmail()==null || professional.getPassword()==null) return -1;
	    // If the user with the provided email doesn't exist
	    if (user1 == null) {
	        return -1; // User does not exist
	    }

	    // Check if the password matches
	    if (user1.getPassword().equals(professional.getPassword())) {
	       return 1;
	    } else {
	        return 0; // Invalid email or password
	    }
		
	}

//	@Override
//	public List<Bookings> listbookings(Professional professional) {
//		// TODO Auto-generated method stub
//		return prepo.findAll(professional);
//	}



}
