package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Seed;

public interface seedDao extends JpaRepository<Seed, Integer> {
	
	public List<Seed> findByCommonName(String commonName);
    public  List<Seed> findByTypeOfSeeds(String typeOfSeeds);


}
