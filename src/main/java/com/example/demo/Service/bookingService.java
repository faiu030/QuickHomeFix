package com.example.demo.Service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Services;
import com.example.demo.Entity.User;

@Service
public interface bookingService {

	String bookservice(User user, LocalDateTime t);

}
