package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Cart;
import com.example.demo.Entity.Services;
import com.example.demo.Entity.User;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {

	Cart findByUserAndServices(User u, Services s);

	

	List<Cart> findByUser(User user);

	

	

	

}
