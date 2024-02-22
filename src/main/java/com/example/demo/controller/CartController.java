package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Entity.Cart;

import com.example.demo.Entity.User;
import com.example.demo.Service.CartService;
import com.example.demo.dto.Cartdto;

@RestController
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping("/addordeleteitemincart")
    public ResponseEntity<String> addOrDeleteItemInCart(@RequestBody Cartdto item) {
        try {
            String response = cartService.addordelete(item.getUser(), item.getServices());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred: " + e.getMessage());
        }
    }

    @GetMapping("/listcartitems")
    public ResponseEntity<List<Cart>> listCartItems(@RequestBody User user) {
        try {
            List<Cart> cartItems = cartService.listcartitems(user);
            return ResponseEntity.ok(cartItems);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
