package com.example.demo.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Services services;

	private double cost;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Cart(long id, User user, Services services, double cost) {
		super();
		this.id = id;
		this.user = user;
		this.services = services;
		this.cost = cost;
	}

	public Cart() {
		super();
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", user=" + user + ", services=" + services + ", cost=" + cost + "]";
	}
	
	
}
