package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Cart;
import com.example.demo.Entity.Services;
import com.example.demo.Entity.User;
import com.example.demo.Service.CartService;
import com.example.demo.dto.Cartdto;

@RestController
public class CartController {

	@Autowired
	CartService cartservice;
	
	//addordelete item from cart
	@PostMapping("/addordeleteitemincart")
	public String addordelete(@RequestBody Cartdto item)
	{
		Services services=item.getServices();
		User user=item.getUser();
		return cartservice.addordelete(user,services);
	}
	
	@GetMapping("/listcartitems")
	public List<Cart> listcartitems(@RequestBody User user){
		return cartservice.listcartitems(user);
	}
}
