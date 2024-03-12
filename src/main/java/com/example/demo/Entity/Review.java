package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private User user;
    
    @ManyToOne
    private QuickService quickService;
    
    @ManyToOne
    private Professional professional;
    
    private int rating;
    private String review;

    // Constructors
    public Review() {}

    public Review(Long id, User user, QuickService quickService, Professional professional, int rating, String review) {
        this.id = id;
        this.user = user;
        this.quickService = quickService;
        this.professional = professional;
        this.rating = rating;
        this.review = review;
    }

    // Getters and Setters
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

    public QuickService getQuickService() {
        return quickService;
    }

    public void setQuickService(QuickService quickService) {
        this.quickService = quickService;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
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

    @Override
    public String toString() {
        return "Review [id=" + id + ", user=" + user + ", quickService=" + quickService +
                ", professional=" + professional + ", rating=" + rating + ", review=" + review + "]";
    }
}
