package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.planterException;
import com.masai.exception.seedException;
import com.masai.model.Plant;
import com.masai.model.Planter;
import com.masai.model.Seed;
import com.masai.repository.planterDao;


@Service
public class planterServiceImpl implements planterSerive {

	
	@Autowired
	private planterDao getPlanterDao;
	
	
	@Override
	public Planter addPlanter(Planter planters) throws planterException{
		
		Planter savePlanter= getPlanterDao.save(planters);
	
		if(savePlanter==null) {
			throw new planterException("This planter is already present");
			
		}
		else {
			return savePlanter;
		}
		
		
		
	}


	@Override
	public Planter updatePlanter(Planter planters) throws planterException {
		   Optional<Planter> checkPlanter=getPlanterDao.findById(planters.getPlanterId());
			
			if(!checkPlanter.isPresent()) {
				throw new planterException("planter is not exist, try to enter correct details of planter");
				
			}else {
				return getPlanterDao.save(planters);
			}
	}


	@Override
	public Planter DeletePlanter(Integer planterId) throws planterException {
		 Optional<Planter> deletePlanter= getPlanterDao.findById(planterId);
			
			if(deletePlanter.isPresent()) {
				Planter delPlanter=deletePlanter.get();
				
				getPlanterDao.delete(delPlanter);
				
				return delPlanter;
			}
			else {
				throw new planterException("planter is not found by this planterId");
			}
	}


	@Override
	public Planter viewPlanter(Integer palnterId) throws planterException {
		
	Optional<Planter> viewPlanter= getPlanterDao.findById(palnterId);
        
        if(viewPlanter.isPresent()) {
      	  return viewPlanter.get();
        }else {
      	  throw new planterException("Planter is not found by this planterId");
        }
	}


	@Override
	public List<Planter> viewAllPlanters() throws planterException {
          List<Planter> allplanters= getPlanterDao.findAll();
		
		if(allplanters.size()>0) {
			return allplanters;
		}else {
			throw new planterException("no planters available");
		}  

	}


	@Override
	public List<Planter> viewAllPlantersByPlanterShape(String shape) throws planterException {
		 List<Planter> seedByShape= getPlanterDao.findByPlanterShape(shape);
			
			if(seedByShape.size()>0) {
				return seedByShape;
			}else {
				throw new planterException("no planter found by this shape");
			}
			
	}


	@Override
	public List<Planter> viewAllPlantersByShorting(Integer sCost, Integer eCost) throws planterException {
		
		List<Planter> shortPlanter= getPlanterDao.findByPlanterCostBetween(sCost,eCost);
		if(shortPlanter.size()>0) {
			return shortPlanter;
		}else {
			throw new planterException("no planter available");
		}
		
	}

}
