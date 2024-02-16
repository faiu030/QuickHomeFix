package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Services;

public interface servicesrepo extends JpaRepository<Services, Long> {

	Services findByName(String string);

	

}
