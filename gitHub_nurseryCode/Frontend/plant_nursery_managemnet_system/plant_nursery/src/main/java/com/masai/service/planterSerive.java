package com.masai.service;

import java.util.List;

import com.masai.exception.planterException;
import com.masai.exception.seedException;
import com.masai.model.Planter;
import com.masai.model.Seed;

public interface planterSerive {
	
	public Planter addPlanter(Planter planters) throws planterException;
	public Planter updatePlanter(Planter planters) throws planterException;
	public Planter DeletePlanter(Integer planterId)throws planterException;
	public Planter viewPlanter(Integer palnterId) throws planterException;
	public List<Planter> viewAllPlanters()throws planterException;
	public List<Planter>viewAllPlantersByPlanterShape(String shape) throws planterException;
	public List<Planter>viewAllPlantersByShorting(Integer sCost,Integer eCost) throws planterException;
	

}
