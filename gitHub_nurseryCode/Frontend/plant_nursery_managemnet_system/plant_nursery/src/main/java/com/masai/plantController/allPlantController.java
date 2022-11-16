package com.masai.plantController;

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
import com.masai.model.Plant;
import com.masai.service.PlantService;

@CrossOrigin(origins = "*")
@RestController
public class allPlantController {
	
	@Autowired
	private PlantService getplantservice;
	
	@PostMapping("naturenursery/addPlant")
	public ResponseEntity<Plant> addplantHandler(@RequestBody Plant plants) throws plantException{
		
		Plant plant= getplantservice.addPlantDetails(plants);
		
		return new ResponseEntity<Plant>(plant,HttpStatus.CREATED);
		
	}
	
	@PutMapping("naturenursery/updatePlant")
	public ResponseEntity<Plant>updatePlantHandler(@RequestBody Plant plants)throws plantException{
		Plant plant= getplantservice.updatePlant(plants);
		
		return new ResponseEntity<Plant>(plant,HttpStatus.OK);
	}
	
	@DeleteMapping("naturenursery/deletePlant/{plantId}")
	public ResponseEntity<Plant> deletePlantHandler(@PathVariable("plantId") Integer plantId)throws plantException{
		Plant plant= getplantservice.DeletePlant(plantId);
		
		return new ResponseEntity<Plant>(plant,HttpStatus.OK);
		
	}
	
	@GetMapping("naturenursery/viewPlant/{plantId}")
	public ResponseEntity<Plant> viewPantHandler(@PathVariable("plantId") Integer plantId) throws plantException{
		
		Plant plant=getplantservice.viewPlant(plantId);
		
		return new ResponseEntity<Plant>(plant,HttpStatus.OK);
	}
	
	
	
	@GetMapping("naturenursery/viewAllPlant")
	public ResponseEntity<List<Plant>> viewAllPantHandler() throws plantException{
		
		List<Plant> allplants=getplantservice.viewAllPlants();
		
		return new ResponseEntity<List<Plant>>(allplants,HttpStatus.OK);
	}
	
	@GetMapping("naturenursery/viewPlantByName/{commonName}")
	public ResponseEntity<List<Plant>> viewPlanterByNameHandler(@PathVariable("commonName") String commonName) throws plantException{
		
		List<Plant> allplants=getplantservice.viewAllPantsByName(commonName);
		
		return new ResponseEntity<List<Plant>>(allplants,HttpStatus.OK);
	}
	
	@GetMapping("naturenursery/viewPlantByType/{typeOfPlant}")
	public ResponseEntity<List<Plant>> viewPlanterByTypeHandler(@PathVariable("typeOfPlant") String typeOfPlant) throws plantException{
		
		List<Plant> allplants=getplantservice.viewAllPantsByType(typeOfPlant);
		
		return new ResponseEntity<List<Plant>>(allplants,HttpStatus.OK);
	}
}
