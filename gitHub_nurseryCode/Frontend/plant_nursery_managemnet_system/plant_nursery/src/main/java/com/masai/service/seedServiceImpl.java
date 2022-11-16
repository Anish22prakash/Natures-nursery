package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.plantException;
import com.masai.exception.seedException;
import com.masai.model.Plant;
import com.masai.model.Seed;
import com.masai.repository.seedDao;

@Service
public class seedServiceImpl implements seedService {
	
	@Autowired
	private seedDao getseedDao;

	
	@Override
	public Seed addSeed(Seed seeds) throws seedException {
		Seed saveSeed= getseedDao.save(seeds);
		
		if(saveSeed==null) {
			throw new seedException("This seed can't be added");
			
		}
		else {
			return saveSeed;
		}
		
		
	}


	@Override
	public Seed updateSeed(Seed seeds) throws seedException {
    Optional<Seed> checkSeed=getseedDao.findById(seeds.getSeedId());
		
		if(!checkSeed.isPresent()) {
			throw new seedException("seed is not exist, try to enter correct details of seed");
			
		}else {
			return getseedDao.save(seeds);
		}
		
	}


	@Override
	public Seed DeleteSeed(Integer seedId) throws seedException {
    Optional<Seed> deleteSeed= getseedDao.findById(seedId);
		
		if(deleteSeed.isPresent()) {
			Seed delSeed=deleteSeed.get();
			
			getseedDao.delete(delSeed);
			
			return delSeed;
		}
		else {
			throw new seedException("seed is not found by this seedId");
		}
	}


	@Override
	public Seed viewSeed(Integer seedId) throws seedException {
		
		Optional<Seed> viewSeed= getseedDao.findById(seedId);
        
        if(viewSeed.isPresent()) {
      	  return viewSeed.get();
        }else {
      	  throw new seedException("seed is not found by this seedId");
        }
		
	}


	@Override
	public List<Seed> viewAllSeeds() throws seedException {
      List<Seed> allseeds= getseedDao.findAll();
		
		if(allseeds.size()>0) {
			return allseeds;
		}else {
			throw new seedException("no seeds available");
		}       
	}


	@Override
	public List<Seed> viewAllSeedsByCommonName(String commmonName) throws seedException {
     List<Seed> seedByName= getseedDao.findByCommonName(commmonName);
		
		if(seedByName.size()>0) {
			return seedByName;
		}else {
			throw new seedException("no seed found by this name");
		}
		
	}


	@Override
	public List<Seed> viewAllSeedsByType(String typeOfSeed) throws seedException {
		List<Seed> seedByType= getseedDao.findByTypeOfSeeds(typeOfSeed);
				if(seedByType.size()>0) {
					return seedByType;
				}else {
					throw new seedException("no seed found by this type");
				}
				
	}
	
	

}
