package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Planter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer planterId;
	
	
	private Float planterHeight;
	private Integer planterCapacity;
	private Integer drinageHoles;
	private String planterColor;
	private String url;
	private String planterShape;
	private Integer planterStock;
	private Integer planterCost;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Plant plants;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Seed seeds;

	public Integer getPlanterId() {
		return planterId;
	}

	public void setPlanterId(Integer planterId) {
		this.planterId = planterId;
	}

	public Float getPlanterHeight() {
		return planterHeight;
	}

	public void setPlanterHeight(Float planterHeight) {
		this.planterHeight = planterHeight;
	}

	public Integer getPlanterCapacity() {
		return planterCapacity;
	}

	public void setPlanterCapacity(Integer planterCapacity) {
		this.planterCapacity = planterCapacity;
	}

	public Integer getDrinageHoles() {
		return drinageHoles;
	}

	public void setDrinageHoles(Integer drinageHoles) {
		this.drinageHoles = drinageHoles;
	}

	public String getPlanterColor() {
		return planterColor;
	}

	public void setPlanterColor(String planterColor) {
		this.planterColor = planterColor;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPlanterShape() {
		return planterShape;
	}

	public void setPlanterShape(String planterShape) {
		this.planterShape = planterShape;
	}

	public Integer getPlanterStock() {
		return planterStock;
	}

	public void setPlanterStock(Integer planterStock) {
		this.planterStock = planterStock;
	}

	public Integer getPlanterCost() {
		return planterCost;
	}

	public void setPlanterCost(Integer planterCost) {
		this.planterCost = planterCost;
	}

	public Plant getPlants() {
		return plants;
	}

	public void setPlants(Plant plants) {
		this.plants = plants;
	}

	public Seed getSeeds() {
		return seeds;
	}

	public void setSeeds(Seed seeds) {
		this.seeds = seeds;
	}

	public Planter(Integer planterId, Float planterHeight, Integer planterCapacity, Integer drinageHoles,
			String planterColor, String url, String planterShape, Integer planterStock, Integer planterCost,
			Plant plants, Seed seeds) {
		super();
		this.planterId = planterId;
		this.planterHeight = planterHeight;
		this.planterCapacity = planterCapacity;
		this.drinageHoles = drinageHoles;
		this.planterColor = planterColor;
		this.url = url;
		this.planterShape = planterShape;
		this.planterStock = planterStock;
		this.planterCost = planterCost;
		this.plants = plants;
		this.seeds = seeds;
	}

	public Planter() {
		
	}

	
	
	
	
	
	

}
