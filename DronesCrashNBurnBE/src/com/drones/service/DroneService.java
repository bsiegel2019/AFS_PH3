package com.drones.service;

import java.util.List;

import com.drones.model.Drone;

public interface DroneService {

	List<Drone> findAllDrones();

	Drone findDroneByDroneId(Long id);

	Drone addDrone(Drone drone);

	Long deleteDroneById(Long id);
}
