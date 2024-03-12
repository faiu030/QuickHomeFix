package com.example.demo.dto;

import com.example.demo.entity.QuickService;
import com.example.demo.entity.User;

public class CartDto {
    
    private User user;
    private QuickService quickService;

    // Constructors
    public CartDto() {}

    public CartDto(User user, QuickService quickService) {
        this.user = user;
        this.quickService = quickService;
    }

    // Getters and Setters
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

    @Override
    public String toString() {
        return "CartDto [user=" + user + ", quickService=" + quickService + "]";
    }
}
