package com.drones.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.drones.manager.DroneManager;
import com.drones.model.Drone;

@Controller
public class DroneController {

	private static final Logger LOGGER = Logger.getLogger(DroneController.class.getName());

	@Autowired
	private DroneManager droneManager;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getIndexPage() {
		LOGGER.log(Level.INFO, "RequestMapping(value = \"/\", method = RequestMethod.GET)");
		return "index";
	}

	@RequestMapping(value = "/droneComments", method = RequestMethod.GET)
	public String getCommentPage() {
		LOGGER.log(Level.INFO, "RequestMapping(value = \"/droneComments\", method = RequestMethod.GET)");
		return "droneComments";
	}

	@RequestMapping(value = "/droneCentral", method = RequestMethod.GET)
	public ModelAndView showForm() {
		LOGGER.log(Level.INFO, "RequestMapping(value = \"/droneCentral\", method = RequestMethod.GET)");
		return new ModelAndView("droneCentral", "drone", droneManager.findAllDrones());
	}

	@RequestMapping(value = "/droneAdd", method = RequestMethod.GET)
	public ModelAndView showForm1() {
		LOGGER.log(Level.INFO, "equestMapping(value = \"/droneAdd\", method = RequestMethod.GET)");
		return new ModelAndView("droneAdd", "drone", new Drone());
	}

	@RequestMapping(value = "/droneConfirmation", method = RequestMethod.POST)
	public ModelAndView submitDrone(@Valid @ModelAttribute("drone") Drone drone, BindingResult result) {
		LOGGER.log(Level.INFO, "RequestMapping(value = \"/droneConfirmation\", method = RequestMethod.POST)" + "Drone="
				+ drone.toString());
		droneManager.addDrone(drone);
		return new ModelAndView("droneConfirmation", "drone", drone);
	}

}
