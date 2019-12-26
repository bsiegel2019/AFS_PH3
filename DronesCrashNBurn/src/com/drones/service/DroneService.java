package com.drones.service;

import java.util.List;

import com.drones.model.Drone;

public interface DroneService {

	List<Drone> findAllDrones();

	Drone addDrone(Drone drone);

	Drone findDroneByDroneId(Long id);

	void deleteDroneById(Long id); // TODO return something

}
