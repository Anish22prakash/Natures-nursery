package com.masai.service;

import java.util.List;

import com.masai.exception.plantException;
import com.masai.exception.seedException;
import com.masai.model.Plant;
import com.masai.model.Seed;

public interface PlantService {
	
	public Plant addPlantDetails(Plant plants) throws plantException;
	public Plant updatePlant(Plant plants) throws plantException;
	public Plant DeletePlant(Integer plantId)throws plantException;
	public Plant viewPlant(Integer plantId) throws plantException;
	public List<Plant> viewAllPlants()throws plantException;
	public List<Plant> viewAllPantsByName(String commonName) throws plantException;
	public List<Plant> viewAllPantsByType(String typeOfPlant) throws plantException;
	
	


}
