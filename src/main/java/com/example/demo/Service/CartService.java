package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Cart;
import com.example.demo.Entity.Services;
import com.example.demo.Entity.User;
import com.example.demo.dto.Cartdto;

public interface CartService {

	

	String addordelete(User user, Services services);

	List<Cart> listcartitems(User user);

}
