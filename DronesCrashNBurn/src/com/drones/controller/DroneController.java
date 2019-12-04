package com.drones.controller;

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

	@Autowired
	private DroneManager droneManager;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getIndexPage() {
		return "index";
	}

	@RequestMapping(value = "/droneManagement", method = RequestMethod.GET)
	public ModelAndView showForm() {
		return new ModelAndView("droneManagement", "drone", droneManager.findAllDrones());
	}

	@RequestMapping(value = "/droneAdd", method = RequestMethod.GET)
	public ModelAndView showForm1() {
		return new ModelAndView("droneAdd", "drone", new Drone());
	}

	@RequestMapping(value = "/droneConfirmation", method = RequestMethod.POST)
	public ModelAndView submitDrone(@Valid @ModelAttribute("drone") Drone drone, BindingResult result) {
		droneManager.addDrone(drone);
		return new ModelAndView("droneConfirmation", "drone", drone);
	}

}
