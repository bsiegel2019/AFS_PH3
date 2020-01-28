package com.dronexbe.service;

import java.util.List;

import com.dronexbe.model.Drone;

public interface DroneService {

	List<Drone> findAllDrones();

	Drone findDroneByDroneId(Long id);

	Drone addDrone(Drone drone);

	Long deleteDroneById(Long id);
}
