package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Services;

public interface servicesservice {

	Services addservice(Services service);

	void updateservice(Services serviceDetails);

	List<Services> listingservices();

	void deleteservices(Services servicedetails);

}
