package com.drones.controller;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DroneCommentController {

	private static final Logger LOGGER = Logger.getLogger(DroneCommentController.class.getName());

//	@Autowired
//	private DroneManager droneManager;

	@RequestMapping(value = "/droneComments", method = RequestMethod.GET)
	public String getCommentPage() {
		return "droneComments";
	}

//	@RequestMapping(value = "/droneComment", method = RequestMethod.GET)
//	public ModelAndView submitDrone(@Valid @ModelAttribute("drone") DroneComment droneComment, BindingResult result) {
// //		droneManager.addDrone(drone);
//		return new ModelAndView("droneConfirmation", "drone", drone);
//	}

//	@RequestMapping(value = "/droneConfirmation", method = RequestMethod.POST)
//	public ModelAndView submitDrone(@Valid @ModelAttribute("drone") Drone drone, BindingResult result) {
//		droneManager.addDrone(drone);
//		return new ModelAndView("droneConfirmation", "drone", drone);
//	}

}
