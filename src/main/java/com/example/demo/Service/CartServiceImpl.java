package com.example.demo.Service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Cart;
import com.example.demo.Entity.Services;
import com.example.demo.Entity.User;
import com.example.demo.Repo.CartRepo;
import com.example.demo.Repo.servicesrepo;
import com.example.demo.Repo.userrepo;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepo cartRepo;

    @Autowired
    userrepo userRepo;

    @Autowired
    servicesrepo servicesRepo;

    @Override
    public String addordelete(User user, Services services) {
        try {
            User existingUser = userRepo.findByEmail(user.getEmail());
            Services existingService = servicesRepo.findByName(services.getName());

            if (existingUser == null || existingService == null) {
                return "User or service does not exist";
            }

            Cart existingCart = cartRepo.findByUserAndServices(existingUser, existingService);
            if (existingCart == null) {
                Cart cart = new Cart();
                cart.setUser(existingUser);
                cart.setServices(existingService);
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
