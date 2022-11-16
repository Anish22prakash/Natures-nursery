package com.masai.service;

import java.util.List;

import com.masai.exception.plantException;
import com.masai.exception.seedException;
import com.masai.model.Plant;
import com.masai.model.Seed;

public interface seedService {
	
	public Seed addSeed(Seed seeds) throws seedException;
	public Seed updateSeed(Seed seeds) throws seedException;
	public Seed DeleteSeed(Integer seedId)throws seedException;
	public Seed viewSeed(Integer seedId) throws seedException;
	public List<Seed> viewAllSeeds()throws seedException;
	public List<Seed>viewAllSeedsByCommonName(String commmonName) throws seedException;
	public List<Seed> viewAllSeedsByType(String typeOfSeed) throws seedException;
	
	

}
