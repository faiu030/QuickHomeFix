package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.Entity.Reviews;
import com.example.demo.Entity.Services;
import com.example.demo.Entity.User;
import com.example.demo.Repo.Reviewsrepo;
import com.example.demo.Repo.userrepo;
import com.example.demo.dto.Reviewsdto;

@Service
public class ReviesServiceImpl  implements ReviesService{

	@Autowired
	Reviewsrepo rr;
	
	@Autowired
	userrepo ur;
	@Override
	public void writereview(Reviews rdto) {
		// TODO Auto-generated method stub
		rr.save(rdto);
	}
	
//	@Override
//	public List<String> readreviewbyservice(long sid) {
//		// TODO Auto-generated method stub
//		return rr.findAllById(sid);
//	}

}
