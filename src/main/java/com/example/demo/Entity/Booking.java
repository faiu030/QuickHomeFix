package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Professional professional;

    @ManyToOne
    private QuickService quickService;

    private LocalDateTime bookingDateTime;
    private LocalDateTime scheduledDateTime;
    
    private int paymentStatus;
    private int serviceStatus;

    // Constructors
    public Booking() {}

    public Booking(Long id, User user, Professional professional, QuickService quickService,
                   LocalDateTime bookingDateTime, LocalDateTime scheduledDateTime,
                   int paymentStatus, int serviceStatus) {
        this.id = id;
        this.user = user;
        this.professional = professional;
        this.quickService = quickService;
        this.bookingDateTime = bookingDateTime;
        this.scheduledDateTime = scheduledDateTime;
        this.paymentStatus = paymentStatus;
        this.serviceStatus = serviceStatus;
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

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    public QuickService getQuickService() {
        return quickService;
    }

    public void setQuickService(QuickService quickService) {
        this.quickService = quickService;
    }

    public LocalDateTime getBookingDateTime() {
        return bookingDateTime;
    }

    public void setBookingDateTime(LocalDateTime bookingDateTime) {
        this.bookingDateTime = bookingDateTime;
    }

    public LocalDateTime getScheduledDateTime() {
        return scheduledDateTime;
    }

    public void setScheduledDateTime(LocalDateTime scheduledDateTime) {
        this.scheduledDateTime = scheduledDateTime;
    }

    public int getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(int paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public int getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(int serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    @Override
    public String toString() {
        return "Booking [id=" + id + ", user=" + user + ", professional=" + professional +
                ", quickService=" + quickService + ", bookingDateTime=" + bookingDateTime +
                ", scheduledDateTime=" + scheduledDateTime + ", paymentStatus=" + paymentStatus +
                ", serviceStatus=" + serviceStatus + "]";
    }
}
