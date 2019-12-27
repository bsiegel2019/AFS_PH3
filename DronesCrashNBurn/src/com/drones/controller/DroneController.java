package com.drones.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.drones.manager.DroneManager;
import com.drones.model.Drone;

@Controller
public class DroneController {

	private static final Logger LOGGER = Logger.getLogger(DroneController.class.getName());

	@Autowired
	private DroneManager droneManager; // Service which will do all data retrieval/manipulation work

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getIndexPage() {
		return "redirect:droneCrashPage";
	}

	@RequestMapping(value = "/droneCrashPage", method = RequestMethod.GET)
	public String getCrashPage() {
		return "droneCrashPage";
	}

	// -------------------Find ALL Drones----------
	@RequestMapping(value = "/droneCentral", method = RequestMethod.GET)
	public ModelAndView showForm() {
		return new ModelAndView("droneCentral", "drone", droneManager.findAllDrones());
	}

	// -------------------Add a Drone----------
	@RequestMapping(value = "/droneAdd", method = RequestMethod.GET)
	public ModelAndView showForm1() {
		return new ModelAndView("droneAdd", "drone", new Drone());
	}

	// -------------------Confirmation for Add a Drone----------
	@RequestMapping(value = "/droneConfirmation", method = RequestMethod.POST)
	public ModelAndView submitDrone(@Valid @ModelAttribute("drone") Drone drone, BindingResult result) {
		return new ModelAndView("droneConfirmation", "drone", droneManager.addDrone(drone));
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
	@RequestMapping(value = "/drones/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Drone> deleteDrones(@PathVariable("id") Long id) {

		Drone drone = droneManager.findDroneByDroneId(id);

		if (null == drone) {
			LOGGER.log(Level.SEVERE,
					this.getClass().getName() + " >No Drone found for deleteDrones(" + id + "). One was expected!");
			return new ResponseEntity<Drone>(HttpStatus.NOT_FOUND);
		}
		Long deleteRowCount = droneManager.deleteDroneById(id);

		if (deleteRowCount == 1) {
			return new ResponseEntity<Drone>(HttpStatus.OK);
		} else if (deleteRowCount == 0) {
			LOGGER.log(Level.WARNING,
					this.getClass().getName() + " >deleteDrones(" + id + ") did not delete. One was expected!");
			return new ResponseEntity<Drone>(HttpStatus.BAD_REQUEST);
		} else {
			LOGGER.log(Level.SEVERE,
					this.getClass().getName() + " >deleteDrones(" + id + ") failed rowcount=" + deleteRowCount);
			return new ResponseEntity<Drone>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// ----------Find a Drone by drone id for the comment page
	@RequestMapping(value = "/drones/{id}", method = RequestMethod.GET)
	public ResponseEntity<Drone> findDroneByDroneId(@PathVariable("id") Long id) {

		Drone drone = droneManager.findDroneByDroneId(id);

		if (null == drone) {
			LOGGER.log(Level.SEVERE, this.getClass().getName() + " >No Drone found for findDroneByDroneId(" + id
					+ "). One was expected!");
			return new ResponseEntity<Drone>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Drone>(drone, HttpStatus.OK);
	}

}
