package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Services;
import com.example.demo.Repo.servicesrepo;

@Service
public class ServicesserviceImpl implements servicesservice{

	@Autowired
	servicesrepo r;
	@Override
	public Services addservice(Services service) {
		// TODO Auto-generated method stub
		return r.save(service);
	}
	@Override
	public void updateservice(Services serviceDetails) {
		// TODO Auto-generated method stub
      Services service = r.findByName(serviceDetails.getName());
      service.setName(serviceDetails.getName());
      service.setDescription(serviceDetails.getDescription());
      service.setCost(serviceDetails.getCost());

      r.save(service);


	}
	@Override
	public List<Services> listingservices() {
		// TODO Auto-generated method stub
		return r.findAll();
	}
	
	
	@Override
	public void deleteservices(Services servicedetails) {
		// TODO Auto-generated method stub
		Services ser=r.findByName(servicedetails.getName());
		r.delete(ser);
	}

	

}
