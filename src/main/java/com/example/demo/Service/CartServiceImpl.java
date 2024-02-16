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
import com.example.demo.dto.Cartdto;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepo cr;

    @Autowired
    userrepo ur;

    @Autowired
    servicesrepo sr;

    @Override
    public String addordelete(User user, Services services) {
        User existingUser = ur.findByEmail(user.getEmail());
        Services existingService = sr.findByName(services.getName());

        if (existingUser == null || existingService == null) {
            return "User or service does not exist";
        }

        Cart existingCart = cr.findByUserAndServices(existingUser, existingService);
        if (existingCart == null) {
            Cart cart = new Cart();
            cart.setUser(existingUser);
            cart.setServices(existingService);
            cart.setCost(existingService.getCost());
            cr.save(cart);
            return "Item added to cart";
        } else {
            cr.delete(existingCart);
            return "Item deleted from cart";
        }
    }

    @Override
    public List<Cart> listcartitems(User user) {
        User existingUser = ur.findByEmail(user.getEmail());
        if (existingUser != null) {
            return cr.findByUser(existingUser);
        } else {
            return Collections.emptyList();
        }
    }
}
