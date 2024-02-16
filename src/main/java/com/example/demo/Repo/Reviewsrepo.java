package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Reviews;


@Repository
public interface Reviewsrepo extends JpaRepository<Reviews, Long>{

	//List<String> findAllById(long sid);

}
