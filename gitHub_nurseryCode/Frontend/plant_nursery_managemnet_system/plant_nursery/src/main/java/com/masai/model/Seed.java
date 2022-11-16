package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Seed {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer seedId;
	
	
	private String commonName;
	private String bloomTime;
	private String url;
	private String watering;
	private String difficultyLevel;
	private String tempurature;
	private String typeOfSeeds;
	private String seedsDescription;
	private String seedStock;
	private Double seedsCost;
	private Integer seedsPerPacket;
	
	
	public Integer getSeedId() {
		return seedId;
	}
	public void setSeedId(Integer seedId) {
		this.seedId = seedId;
	}
	public String getCommonName() {
		return commonName;
	}
	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}
	public String getBloomTime() {
		return bloomTime;
	}
	public void setBloomTime(String bloomTime) {
		this.bloomTime = bloomTime;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getWatering() {
		return watering;
	}
	public void setWatering(String watering) {
		this.watering = watering;
	}
	public String getDifficultyLevel() {
		return difficultyLevel;
	}
	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}
	public String getTempurature() {
		return tempurature;
	}
	public void setTempurature(String tempurature) {
		this.tempurature = tempurature;
	}
	public String getTypeOfSeeds() {
		return typeOfSeeds;
	}
	public void setTypeOfSeeds(String typeOfSeeds) {
		this.typeOfSeeds = typeOfSeeds;
	}
	public String getSeedsDescription() {
		return seedsDescription;
	}
	public void setSeedsDescription(String seedsDescription) {
		this.seedsDescription = seedsDescription;
	}
	public String getSeedStock() {
		return seedStock;
	}
	public void setSeedStock(String seedStock) {
		this.seedStock = seedStock;
	}
	public Double getSeedsCost() {
		return seedsCost;
	}
	public void setSeedsCost(Double seedsCost) {
		this.seedsCost = seedsCost;
	}
	public Integer getSeedsPerPacket() {
		return seedsPerPacket;
	}
	public void setSeedsPerPacket(Integer seedsPerPacket) {
		this.seedsPerPacket = seedsPerPacket;
	}
	
	
	public Seed(Integer seedId, String commonName, String bloomTime, String url, String watering,
			String difficultyLevel, String tempurature, String typeOfSeeds, String seedsDescription, String seedStock,
			Double seedsCost, Integer seedsPerPacket) {
		super();
		this.seedId = seedId;
		this.commonName = commonName;
		this.bloomTime = bloomTime;
		this.url = url;
		this.watering = watering;
		this.difficultyLevel = difficultyLevel;
		this.tempurature = tempurature;
		this.typeOfSeeds = typeOfSeeds;
		this.seedsDescription = seedsDescription;
		this.seedStock = seedStock;
		this.seedsCost = seedsCost;
		this.seedsPerPacket = seedsPerPacket;
	}
	public Seed() {
		
	}
	
}
