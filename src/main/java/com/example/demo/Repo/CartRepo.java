package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Cart;
import com.example.demo.entity.QuickService;
import com.example.demo.entity.User;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {

    Cart findByUserAndService(User user, QuickService service); 

    List<Cart> findByUser(User user);

}
