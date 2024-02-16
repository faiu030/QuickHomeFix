package com.example.demo.dto;

import com.example.demo.Entity.Services;
import com.example.demo.Entity.User;

public class Cartdto {
	
	User user;
	
	Services services;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Services getServices() {
		return services;
	}

	public void setServices(Services services) {
		this.services = services;
	}

	public Cartdto(User user, Services services) {
		super();
		this.user = user;
		this.services = services;
	}

	public Cartdto() {
		super();
	}

	@Override
	public String toString() {
		return "Cartdto [user=" + user + ", services=" + services + "]";
	}
	
	

}
