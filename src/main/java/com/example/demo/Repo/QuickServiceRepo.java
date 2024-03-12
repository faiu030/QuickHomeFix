package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.QuickService;

public interface QuickServiceRepo extends JpaRepository<QuickService, Long> {

	QuickService findByName(String string);

	

}
