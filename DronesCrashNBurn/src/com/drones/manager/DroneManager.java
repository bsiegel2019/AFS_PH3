package com.drones.manager;

import java.util.List;

import com.drones.model.Drone;

public interface DroneManager {

	Drone addDrone(Drone drone);

	List<Drone> findAllDrones();

}
