package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Review;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {

    List<Review> findByQuickServiceId(Long quickServiceId); 

}
