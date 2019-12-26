package com.drones.dao;

import java.util.List;

import com.drones.model.Drone;

public interface DroneDAO {

	List<Drone> findAllDrones();

//	Drone addDrone(Drone drone);
//
//	Drone findDroneByDroneId(Long id);
//
//	void deleteDroneById(Long id); // TODO return something

}
