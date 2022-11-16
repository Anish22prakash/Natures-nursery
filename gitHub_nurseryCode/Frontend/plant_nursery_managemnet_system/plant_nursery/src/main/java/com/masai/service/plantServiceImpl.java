package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import com.masai.exception.plantException;
import com.masai.model.Plant;
import com.masai.repository.plantDao;

@Service
public class plantServiceImpl implements PlantService {

	@Autowired
	private plantDao getplantdao;
	
	
	@Override
	public Plant addPlantDetails(Plant plants) throws plantException{
		
		Plant savePlant= getplantdao.save(plants);
		
		if(savePlant==null) {
			throw new plantException("This plant can't be added in database");
			
		}
		else {
			return savePlant;
		}
		
		
		
	}


	@Override
	public Plant updatePlant(Plant plants) throws plantException {
		
		Optional<Plant> checkPlant=getplantdao.findById(plants.getPlantId());
		
		if(!checkPlant.isPresent()) {
			throw new plantException("plant is not exit, try to enter correct details of plants");
			
		}else {
			return getplantdao.save(plants);
		}
		
	}


	@Override
	public Plant DeletePlant(Integer seedId) throws plantException {
		Optional<Plant> deletePlant= getplantdao.findById(seedId);
		
		if(deletePlant.isPresent()) {
			Plant delPlant=deletePlant.get();
			
			getplantdao.delete(delPlant);
			
			return delPlant;
		}
		else {
			throw new plantException("plant is not found by this plantId");
		}
	}


	@Override
	public Plant viewPlant(Integer plantId) throws plantException {
		
          Optional<Plant> viewPlant= getplantdao.findById(plantId);
          
          if(viewPlant.isPresent()) {
        	  return viewPlant.get();
          }else {
        	  throw new plantException("plant is not found by this plantId");
          }

	}


	@Override
	public List<Plant> viewAllPlants() throws plantException {
		
		List<Plant> allpants= getplantdao.findAll();
		
		if(allpants.size()>0) {
			return allpants;
		}else {
			throw new plantException("no plant available");
		}
		
	}


	@Override
	public List<Plant> viewAllPantsByName(String commonName) throws plantException {
		
		List<Plant> plantByName= getplantdao.findByCommonName(commonName);
		
		if(plantByName.size()>0) {
			return plantByName;
		}else {
			throw new plantException("no plant found by this name");
		}
	
	}


	@Override
	public List<Plant> viewAllPantsByType(String typeOfPlant) throws plantException {
		
       List<Plant> plantByType= getplantdao.findByTypeOfPlant(typeOfPlant);
		
		if(plantByType.size()>0) {
			return plantByType;
		}else {
			throw new plantException("no plant found by this type");
		}
		
		
	}
	
	
	

}
