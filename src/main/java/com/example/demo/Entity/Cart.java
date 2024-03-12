package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private QuickService service;

    private double cost;

    // Constructors
    public Cart() {}

    public Cart(long id, User user, QuickService service, double cost) {
        this.id = id;
        this.user = user;
        this.service = service;
        this.cost = cost;
    }

    // Getters and Setters
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

    public QuickService getService() {
        return service;
    }

    public void setService(QuickService service) {
        this.service = service;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Cart [id=" + id + ", user=" + user + ", service=" + service + ", cost=" + cost + "]";
    }
}
