package com.drones.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DroneCommentController {

//	private static final Logger LOGGER = Logger.getLogger(DroneController.class.getName()); // TODO

	@RequestMapping(value = "/droneComment/{id}", method = RequestMethod.GET)
	public ModelAndView droneComment(@PathVariable("id") Long id) {

		return new ModelAndView("droneComment", "DroneComment", id);
	}

}
