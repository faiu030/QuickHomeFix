package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Reviews;
import com.example.demo.Entity.Services;
import com.example.demo.Service.ReviesService;
import com.example.demo.dto.Reviewsdto;

@RestController
public class ReviewsController {

	@Autowired
	ReviesService rs;
	@PostMapping("/writereview")
	public void writereview(@RequestBody Reviews rdto)
	{
		rs.writereview(rdto);
	}
	
//	@GetMapping("/readreviewbyservice")
//	public List<String> readreviewbyservice(@RequestBody Reviewsdto r)
//	{
//		long sid=r.getServiceId();
//		return rs.readreviewbyservice(sid);
//	}
}
