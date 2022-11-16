package com.masai.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OrderId {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookingOrderId;
	
	private String orderDate;
	private String transactionMode;
	private Integer quantity;
	private Double totalCost;
    
	@JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
	private List<Planter> planters;
    
	@JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
	private List<Plant>plants;
    
	@JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
	private List<Seed>seeds;

	public Integer getBookingOrderId() {
		return bookingOrderId;
	}

	public void setBookingOrderId(Integer bookingOrderId) {
		this.bookingOrderId = bookingOrderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getTransactionMode() {
		return transactionMode;
	}

	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public List<Planter> getPlanters() {
		return planters;
	}

	public void setPlanters(List<Planter> planters) {
		this.planters = planters;
	}

	public List<Plant> getPlants() {
		return plants;
	}

	public void setPlants(List<Plant> plants) {
		this.plants = plants;
	}

	public List<Seed> getSeeds() {
		return seeds;
	}

	public void setSeeds(List<Seed> seeds) {
		this.seeds = seeds;
	}

	public OrderId(Integer bookingOrderId, String orderDate, String transactionMode, Integer quantity, Double totalCost,
			List<Planter> planters, List<Plant> plants, List<Seed> seeds) {
		super();
		this.bookingOrderId = bookingOrderId;
		this.orderDate = orderDate;
		this.transactionMode = transactionMode;
		this.quantity = quantity;
		this.totalCost = totalCost;
		this.planters = planters;
		this.plants = plants;
		this.seeds = seeds;
	}

	public OrderId() {
		
	}
    
  

}
