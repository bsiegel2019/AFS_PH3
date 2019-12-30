package com.drones.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.drones.manager.DroneCommentManager;
import com.drones.model.DroneComment;

@Controller
@RequestMapping("/droneComment")
public class DroneCommentController {

	private static final Logger LOGGER = Logger.getLogger(DroneCommentController.class.getName());

	@Autowired
	DroneCommentManager droneCommentManager; // Service which will do all data retrieval/manipulation work for comment

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView droneComment(@PathVariable("id") Long id) {
		return new ModelAndView("droneComment", "DroneComment", id);
	}

	// -------------------Retrieve All (any) Comments for a Drone----------
	@RequestMapping(value = "/droneComments/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<DroneComment>> findAllDroneCommentByDroneId(@PathVariable("id") Long id) {

		List<DroneComment> droneComments = droneCommentManager.findAllDroneCommentByDroneId(id);

		// no comments (empty, null list) is ok
		if (null == droneComments) {
			LOGGER.log(Level.INFO, this.getClass().getName()
					+ " >No DroneComments found for findAllDroneCommentByDroneId(" + id + ").");
		}

		return new ResponseEntity<List<DroneComment>>(droneComments, HttpStatus.OK);
	}

	// -------------------Retrieve a Comment by comment id----------
	@RequestMapping(value = "/droneComment/{id}", method = RequestMethod.GET)
	public ResponseEntity<DroneComment> findDroneCommentByCommentId(@PathVariable("id") Long id) {

		DroneComment droneComment = droneCommentManager.findDroneCommentByCommentId(id);

		// no comment (empty, null) is ok
		if (null == droneComment) {
			LOGGER.log(Level.INFO,
					this.getClass().getName() + " >No DroneComment found for findDroneCommentByCommentId(" + id + ").");
		}

		return new ResponseEntity<DroneComment>(droneComment, HttpStatus.OK);
	}

}
