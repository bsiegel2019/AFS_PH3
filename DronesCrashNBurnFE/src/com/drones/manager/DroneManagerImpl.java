package com.drones.manager;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drones.model.Drone;
import com.drones.service.DroneService;

@Service("droneManager")
public class DroneManagerImpl implements DroneManager {

	private static final Logger LOGGER = Logger.getLogger(DroneManagerImpl.class.getName());

	@Autowired
	private DroneService droneService;

	public List<Drone> findAllDrones() {
		List<Drone> returnedDrones = droneService.findAllDrones();
		if (returnedDrones.isEmpty()) {
			LOGGER.log(Level.INFO, " >No Drones found for listAllDrones. Zero may happen but one or more expected!");
		}
		return returnedDrones;
	}

	public Drone addDrone(Drone drone) {
		Drone returnedDrone = droneService.addDrone(drone);

		// trap and deal with this possible error
		// the hibernate/mysql addDrone process was to insert the MySQL auto-gen id value into droneId field
		// and return the drone object with that id - if the droneId is null then something failed
		if (null == returnedDrone.getDroneId()) {
			LOGGER.log(Level.SEVERE, " >addDrone(drone) FAILED with a null droneId returned from DB for Drone="
					+ returnedDrone.toString());
		}
		return returnedDrone;
	}

	public Drone findDroneByDroneId(Long id) {
		Drone returnedDrone = droneService.findDroneByDroneId(id);
		if (null == returnedDrone) {
			LOGGER.log(Level.INFO, " >No Drones found for listAllDrones. Zero may happen but one is expected!");
		}
		return returnedDrone;
	}

	public Long deleteDroneById(Long id) {
		return droneService.deleteDroneById(id);
	}
}
