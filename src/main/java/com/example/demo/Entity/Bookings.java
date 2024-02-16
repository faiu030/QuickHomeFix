package com.example.demo.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Bookings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Professional professional;

    @ManyToOne
    private Services service;

    private LocalDateTime bookingDateTime;
    private LocalDateTime scheduledDateTime;
    
    private int paymentstatus;

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

	public Services getService() {
		return service;
	}

	public void setService(Services service) {
		this.service = service;
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

	public int getPaymentstatus() {
		return paymentstatus;
	}

	public void setPaymentstatus(int paymentstatus) {
		this.paymentstatus = paymentstatus;
	}

	public Bookings(Long id, User user, Professional professional, Services service, LocalDateTime bookingDateTime,
			LocalDateTime scheduledDateTime, int paymentstatus) {
		super();
		this.id = id;
		this.user = user;
		this.professional = professional;
		this.service = service;
		this.bookingDateTime = bookingDateTime;
		this.scheduledDateTime = scheduledDateTime;
		this.paymentstatus = paymentstatus;
	}

	public Bookings() {
		super();
	}

	@Override
	public String toString() {
		return "Bookings [id=" + id + ", user=" + user + ", professional=" + professional + ", service=" + service
				+ ", bookingDateTime=" + bookingDateTime + ", scheduledDateTime=" + scheduledDateTime
				+ ", paymentstatus=" + paymentstatus + "]";
	}

}

