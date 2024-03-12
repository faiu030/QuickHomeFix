package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.QuickService;
import com.example.demo.repo.QuickServiceRepo;

@Service
public class QuickServiceServiceImpl implements QuickServiceService{

	@Autowired
	QuickServiceRepo r;
	@Override
	public QuickService addservice(QuickService service) {
		// TODO Auto-generated method stub
		return r.save(service);
	}
	@Override
	public void updateservice(QuickService serviceDetails) {
		// TODO Auto-generated method stub
      QuickService service = r.findByName(serviceDetails.getName());
      service.setName(serviceDetails.getName());
      service.setDescription(serviceDetails.getDescription());
      service.setCost(serviceDetails.getCost());

      r.save(service);


	}
	@Override
	public List<QuickService> listingservices() {
		// TODO Auto-generated method stub
		return r.findAll();
	}
	
	
	@Override
	public void deleteservices(QuickService servicedetails) {
		// TODO Auto-generated method stub
		QuickService ser=r.findByName(servicedetails.getName());
		r.delete(ser);
	}

	

}
