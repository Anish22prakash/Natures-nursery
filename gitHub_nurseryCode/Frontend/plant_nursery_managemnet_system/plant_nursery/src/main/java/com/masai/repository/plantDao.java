package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Plant;

public interface plantDao extends JpaRepository<Plant,Integer> {

	public List<Plant> findByCommonName(String commonName);
	public List<Plant> findByTypeOfPlant(String typeOfPlant);
}
