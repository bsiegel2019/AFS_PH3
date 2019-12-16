package com.drones.service;

import java.util.List;

import com.drones.model.Drone;

public interface DroneService {

	Drone addDrone(Drone drone);

	List<Drone> findAllDrones();

	Drone findDroneByDroneId(Long id);

	void deleteDroneById(Long id); // TODO return something

}
