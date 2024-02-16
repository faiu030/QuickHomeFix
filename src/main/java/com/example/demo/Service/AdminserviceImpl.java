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
	public int verifyadmin(Admin admin) {
		// TODO Auto-generated method stub
		Admin a=ar.findByEmail(admin.getEmail());
		if(admin.getEmail() ==null | admin.getPassword()==null) return -1;
		if(a==null) return -1;
		if(a.getEmail().equals(admin.getEmail()) & a.getPassword().equals(admin.getPassword())) return 1;
		return -1;
	}


	@Override
	public String userlogin(Admin admin) {
		// TODO Auto-generated method stub
		if(ar.findByEmail(admin.getEmail())==null) {
		 ar.save(admin);
		 return "admin created";}
		return"already exist";
	}

	@Override
	public List<Bookings> listallbookings() {
		// TODO Auto-generated method stub
		return br.findAll();
	}
//
	@Override
	public List<Professional> listallprofessionals() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}
//
	@Override
	public List<User> listallusers( ) {
		// TODO Auto-generated method stub
		return ur.findAll();
	}

	@Override
	public String deleteuser(User user) {
		// TODO Auto-generated method stub
		ur.delete(user);
		return "user deleted";
	}
//
	@Override
	public String deleteprofessional(Professional professional) {
		// TODO Auto-generated method stub
		pr.delete(professional);
		return "professional deleted";
	}

}
