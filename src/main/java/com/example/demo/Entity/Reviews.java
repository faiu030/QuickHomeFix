package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Reviews {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Services services;
	

	@ManyToOne
	private Professional professional;
	
	
	public Professional getProfessional() {
		return professional;
	}

	public void setProfessional(Professional professional) {
		this.professional = professional;
	}

	private int rating;
	
	private String review;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Reviews(Long id, User user, Services services, Professional professional, int rating, String review) {
		super();
		this.id = id;
		this.user = user;
		this.services = services;
		this.professional = professional;
		this.rating = rating;
		this.review = review;
	}

	public Reviews() {
		super();
	}

	@Override
	public String toString() {
		return "Reviews [id=" + id + ", user=" + user + ", services=" + services + ", professional=" + professional
				+ ", rating=" + rating + ", review=" + review + "]";
	}

	

	
}
