package com.example.demo.dto;

public class Reviewsdto {

	private Long userId;
	private Long serviceId;
	private Long professionalId;
	private String review;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getServiceId() {
		return serviceId;
	}
	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}
	public Long getProfessionalId() {
		return professionalId;
	}
	public void setProfessionalId(Long professionalId) {
		this.professionalId = professionalId;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	
}
