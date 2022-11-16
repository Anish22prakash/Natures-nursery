package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Jpa21Utils;

import com.masai.model.Planter;

public interface planterDao extends JpaRepository<Planter, Integer> {
	
	public List<Planter> findByPlanterShape(String planterShape);
	public List<Planter> findByPlanterCostBetween(Integer sCOst, Integer eCost);

}
