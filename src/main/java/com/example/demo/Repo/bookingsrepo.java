package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Bookings;

public interface bookingsrepo extends JpaRepository<Bookings, Long >{

}
