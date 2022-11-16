package com.masai.planterController;

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

import com.masai.exception.planterException;
import com.masai.model.Planter;
import com.masai.service.planterSerive;

@CrossOrigin(origins = "*")
@RestController
public class allPlanterContoller  {
	
	@Autowired
    private planterSerive getPlanterService;
    
	
	@PostMapping("naturenursery/addPlanter")
    public ResponseEntity<Planter> addplantHandler(@RequestBody Planter planters) throws planterException {
		
		
    	
    Planter saveplanter= getPlanterService.addPlanter(planters);
    
    return new ResponseEntity<Planter>(saveplanter,HttpStatus.CREATED);
    }
	
	
	@PutMapping("naturenursery/updatePlanter")
	public ResponseEntity<Planter>updateSeedHandler(@RequestBody Planter planters)throws planterException{
		Planter planter= getPlanterService.updatePlanter(planters);
		return new ResponseEntity<Planter>(planter,HttpStatus.OK);
	}
	
	
	@DeleteMapping("naturenursery/deletePlanter/{planterId}")
	public ResponseEntity<Planter> deleteSeedHandler(@PathVariable("planterId") Integer planterId)throws planterException{
		Planter planter= getPlanterService.DeletePlanter(planterId);
		
		return new ResponseEntity<Planter>(planter,HttpStatus.OK);
		
	}
	
	
	@GetMapping("naturenursery/viewPlanter/{planterId}")
	public ResponseEntity<Planter> viewSeedHandler(@PathVariable("planterId") Integer planterId) throws planterException{
		
		Planter planter=getPlanterService.viewPlanter(planterId);
		
		return new ResponseEntity<Planter>(planter,HttpStatus.OK);
	}
	
	@GetMapping("naturenursery/viewAllPlanter")
	public ResponseEntity<List<Planter>> viewAllSeedHandler() throws planterException{
		
		List<Planter> allplanters=getPlanterService.viewAllPlanters();
		
		return new ResponseEntity<List<Planter>>(allplanters,HttpStatus.OK);
	}
	
	@GetMapping("naturenursery/viewPlanterByShape/{Shape}")
	public ResponseEntity<List<Planter>> viewSeedByNameHandler(@PathVariable("Shape") String shape) throws planterException{
		
		List<Planter> allplanter=getPlanterService.viewAllPlantersByPlanterShape(shape);
		
		return new ResponseEntity<List<Planter>>(allplanter,HttpStatus.OK);
	}
	
	@GetMapping("naturenursery/viewPlanterByShort/{sCost}/{eCost}")
	public ResponseEntity<List<Planter>> viewAllPlantersByShortingHandler(@PathVariable("sCost") Integer sCost,@PathVariable("eCost")Integer eCost) throws planterException{
		
		List<Planter> shortPlanter= getPlanterService.viewAllPlantersByShorting(sCost, eCost);
		
	
		return new ResponseEntity<List<Planter>>(shortPlanter,HttpStatus.OK);
	
	
}

}
