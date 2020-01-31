package com.dronexbe.manager;

import java.util.List;

import com.dronexbe.model.Drone;

public interface DroneManager {

	Drone addDrone(Drone drone);

	List<Drone> findAllDrones();

	Drone findDroneByDroneId(Long id);

	Long deleteDroneById(Long id);
	
	Long howManyDrones();
}
