package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Professional;
import com.example.demo.Entity.Reviews;
import com.example.demo.Entity.Services;
import com.example.demo.Entity.User;



public interface ReviesService {

	

	

	

	String writereview(Long bookingId, Long userId, String review, int rating);

	List<Reviews> readreviewbyservice(Long serviceId);



	//List<String> readreviewbyservice(long sid);

}
