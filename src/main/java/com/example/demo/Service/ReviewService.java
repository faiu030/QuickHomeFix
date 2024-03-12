package com.example.demo.service;

import java.util.List;


import com.example.demo.entity.Review;




public interface ReviewService {

	

	

	

	String writereview(Long bookingId, Long userId, String review, int rating);

	List<Review> readreviewbyservice(Long serviceId);



	//List<String> readreviewbyservice(long sid);

}
