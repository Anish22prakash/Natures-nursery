package com.masai.seedController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.plantException;
import com.masai.exception.seedException;
import com.masai.model.Plant;
import com.masai.model.Seed;
import com.masai.service.seedService;

@CrossOrigin(origins = "*")
@RestController
public class allSeedController {
	
	@Autowired
	private seedService getSeedService;
	
	
	@PostMapping("naturenursery/addSeed")
	public ResponseEntity<Seed> addSeed(@RequestBody Seed seeds) throws seedException{
		
		Seed seed= getSeedService.addSeed(seeds);
		
		return new ResponseEntity<Seed>(seed, HttpStatus.CREATED);
	}
	
	@PutMapping("naturenursery/updateSeed")
	public ResponseEntity<Seed>updateSeedHandler(@RequestBody Seed seeds)throws seedException{
		Seed seed= getSeedService.updateSeed(seeds);
		return new ResponseEntity<Seed>(seed,HttpStatus.OK);
	}
	
	@DeleteMapping("naturenursery/deleteSeed/{seedId}")
	public ResponseEntity<Seed> deleteSeedHandler(@PathVariable("seedId") Integer seedId)throws seedException{
		Seed seed= getSeedService.DeleteSeed(seedId);
		
		return new ResponseEntity<Seed>(seed,HttpStatus.OK);
		
	}
	
	@GetMapping("naturenursery/viewSeed/{seedId}")
	public ResponseEntity<Seed> viewSeedHandler(@PathVariable("seeId") Integer seedId) throws seedException{
		
		Seed seed=getSeedService.viewSeed(seedId);
		
		return new ResponseEntity<Seed>(seed,HttpStatus.OK);
	}
	
	@GetMapping("naturenursery/viewAllSeed")
	public ResponseEntity<List<Seed>> viewAllSeedHandler() throws seedException{
		
		List<Seed> allseed=getSeedService.viewAllSeeds();
		
		return new ResponseEntity<List<Seed>>(allseed,HttpStatus.OK);
	}
	
	
	@GetMapping("naturenursery/viewSeedByName/{commonName}")
	public ResponseEntity<List<Seed>> viewSeedByNameHandler(@PathVariable("commonName") String commonName) throws seedException{
		
		List<Seed> allseeds=getSeedService.viewAllSeedsByCommonName(commonName);
		
		return new ResponseEntity<List<Seed>>(allseeds,HttpStatus.OK);
	}
	
	@GetMapping("naturenursery/viewSeedByType/{typeOfPlant}")
	public ResponseEntity<List<Seed>> viewSeedrByTypeHandler(@PathVariable("typeOfSeed") String typeOfSeed) throws seedException{
		
		List<Seed> allseeds=getSeedService.viewAllSeedsByType(typeOfSeed);
		
		return new ResponseEntity<List<Seed>>(allseeds,HttpStatus.OK);
	}
	

}
