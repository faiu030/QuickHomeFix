package com.example.demo.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cart;
import com.example.demo.entity.QuickService;
import com.example.demo.entity.User;
import com.example.demo.repo.CartRepo;
import com.example.demo.repo.QuickServiceRepo;
import com.example.demo.repo.UserRepo;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepo cartRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    QuickServiceRepo quickServiceRepo;

    @Override
    public String addordelete(User user, QuickService services) {
        try {
            User existingUser = userRepo.findByEmail(user.getEmail());
            QuickService existingService = quickServiceRepo.findByName(services.getName());

            if (existingUser == null || existingService == null) {
                return "User or service does not exist";
            }

            Cart existingCart = cartRepo.findByUserAndService(existingUser, existingService);
            if (existingCart == null) {
                Cart cart = new Cart();
                cart.setUser(existingUser);
                cart.setService(existingService);
                cart.setCost(existingService.getCost());
                cartRepo.save(cart);
                return "Item added to cart";
            } else {
                cartRepo.delete(existingCart);
                return "Item deleted from cart";
            }
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while processing cart operation", e);
        }
    }

    @Override
    public List<Cart> listcartitems(User user) {
        try {
            User existingUser = userRepo.findByEmail(user.getEmail());
            if (existingUser != null) {
                return cartRepo.findByUser(existingUser);
            } else {
                return Collections.emptyList();
            }
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while fetching cart items", e);
        }
    }
}
