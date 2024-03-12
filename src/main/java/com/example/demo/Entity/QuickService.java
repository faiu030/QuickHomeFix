package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class QuickService {

	 @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     private String name;
     private String description;
     private double cost;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public QuickService(Long id, String name, String description, double cost) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.cost = cost;
	}
	public QuickService() {
		super();
	}
	@Override
	public String toString() {
		return "Services [id=" + id + ", name=" + name + ", description=" + description + ", cost=" + cost + "]";
	}
	
     
     
}
