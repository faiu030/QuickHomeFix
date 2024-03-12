package com.example.demo.dto;

public class ReviewDto {

	 private String review;
	    private int rating;

	    // Constructors, getters, and setters

	    public ReviewDto() {
	    }

	    public ReviewDto(String review, int rating) {
	        this.review = review;
	        this.rating = rating;
	    }

	    public String getReview() {
	        return review;
	    }

	    public void setReview(String review) {
	        this.review = review;
	    }

	    public int getRating() {
	        return rating;
	    }

	    public void setRating(int rating) {
	        this.rating = rating;
	    }
}
