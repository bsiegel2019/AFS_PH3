package com.drones.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drones.model.Drone;
import com.drones.service.DroneService;

@Service("droneManager")
public class DroneManagerImpl implements DroneManager {

	@Autowired
	private DroneService droneService;

	public List<Drone> findAllDrones() {
		return droneService.findAllDrones();
	}

	public Drone addDrone(Drone drone) {
		return droneService.addDrone(drone);
	}

	public Drone findDroneById(Long id) {
		return droneService.findDroneById(id);
	}

	public void deleteDroneById(Long id) {
		droneService.deleteDroneById(id);
	}
}
