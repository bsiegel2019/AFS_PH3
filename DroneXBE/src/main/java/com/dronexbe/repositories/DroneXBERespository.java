package com.dronexbe.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.dronexbe.model.Drone;

public interface DroneXBERespository extends CrudRepository<Drone, Long> {
	
	//	List<Drone> findAllDrones(); - this from DroneDAO	
	public List<Drone> findAll();

	//	Drone findDroneByDroneId(Long id); - this from Drone DAO
	public Optional<Drone> findById(Long id);

	//	Drone addDrone(Drone drone); - this from DroneDAO
	 @SuppressWarnings("unchecked")
	public Drone save(Drone drone);

	 //	Long deleteDroneById(Long id); - it does not return a count
	 void deleteById(Long id);
	
	 // added - it returns long, not Long
	 long count();
}
