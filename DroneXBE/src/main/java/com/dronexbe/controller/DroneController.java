package com.dronexbe.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dronexbe.manager.DroneManager;
import com.dronexbe.model.Drone;

@RestController
public class DroneController {

	private static final Logger LOGGER = Logger.getLogger(DroneController.class.getName());

	@Autowired
	private DroneManager droneManager;

	// -------------------Add a Drone----------
	// this is a new requirement due to FE/BE split - used to be a controller ModelAndView
	@RequestMapping(value = "/addDrone", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Drone> addDrone(@RequestBody Drone drone) {
		Drone addReturnedDrone = droneManager.addDrone(drone);

		// the DroneId field was null on input and should have been set by hibernate on a successful add
		if (null == addReturnedDrone.getDroneId()) {
			LOGGER.log(Level.SEVERE, " >No DroneId found for addDroneId - ADD failed");
			return new ResponseEntity<Drone>(addReturnedDrone, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return new ResponseEntity<Drone>(addReturnedDrone, HttpStatus.OK);
	}
	
	// -------------------Retrieve All Drones----------
	@RequestMapping(value = "/drones", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Drone>> listAllDrones() {
		List<Drone> returnedDrones = droneManager.findAllDrones();
		if (returnedDrones.isEmpty()) {
			return new ResponseEntity<List<Drone>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Drone>>(returnedDrones, HttpStatus.OK);
	}

	// ------------------- Delete a Drone --------------
	@RequestMapping(value = "/drones/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Drone> deleteDrones(@PathVariable("id") Long id) {
		Drone drone = droneManager.findDroneByDroneId(id);
		if (null == drone) {
			LOGGER.log(Level.SEVERE, " >No Drone found for deleteDrones(" + id + "). One was expected!");
			return new ResponseEntity<Drone>(HttpStatus.NOT_FOUND);
		}

		Long deleteRowCount = droneManager.deleteDroneById(id);
		if (deleteRowCount == 1) {
			return new ResponseEntity<Drone>(HttpStatus.OK);
		} else {
			LOGGER.log(Level.WARNING, " >deleteDrones(" + id + ") did not delete. One was expected!");
			return new ResponseEntity<Drone>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	// ----------Find a Drone by drone id for the comment page
	@RequestMapping(value = "/drones/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Drone> findDroneByDroneId(@PathVariable("id") Long id) {
		Drone drone = droneManager.findDroneByDroneId(id);

		if (null == drone) {
			LOGGER.log(Level.SEVERE, " >No Drone found for findDroneByDroneId(" + id + "). One was expected!");
			return new ResponseEntity<Drone>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Drone>(drone, HttpStatus.OK);
	}

}
