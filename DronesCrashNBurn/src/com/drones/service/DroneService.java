package com.drones.service;

import java.util.List;

import com.drones.model.Drone;

public interface DroneService {

	List<Drone> findAllDrones(); // TODO hib done

	Drone findDroneByDroneId(Long id); // TODO hib done

	Drone addDrone(Drone drone);

	void deleteDroneById(Long id); // TODO return something

}
