package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.QuickService;

public interface QuickServiceService {

	QuickService addservice(QuickService service);

	void updateservice(QuickService serviceDetails);

	List<QuickService> listingservices();

	void deleteservices(QuickService servicedetails);

}
