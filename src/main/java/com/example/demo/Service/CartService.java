package com.example.demo.service;

import java.util.List;


import com.example.demo.entity.Cart;
import com.example.demo.entity.QuickService;
import com.example.demo.entity.User;

public interface CartService {

	

	String addordelete(User user, QuickService services);

	List<Cart> listcartitems(User user);

}
