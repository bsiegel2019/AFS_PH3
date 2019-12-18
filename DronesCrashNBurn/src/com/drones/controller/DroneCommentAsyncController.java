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

import com.drones.manager.DroneCommentManager;
import com.drones.model.DroneComment;

@Controller
public class DroneCommentAsyncController {

	private static final Logger LOGGER = Logger.getLogger(DroneCommentAsyncController.class.getName());

	@Autowired
	DroneCommentManager droneCommentManager; // Service which will do all data retrieval/manipulation work for comment

	// -------------------Retrieve All (any) Comments for a Drone----------
	@RequestMapping(value = "/droneComments/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<DroneComment>> findAllDroneCommentByDroneId(@PathVariable("id") Long id) {

		LOGGER.log(Level.INFO,
				"inside >RequestMapping(value = \"/droneComments/{id}\", method = RequestMethod.GET)< with DroneId="
						+ id);
		LOGGER.log(Level.INFO, "DroneCommentAsyncController  HEREX DroneId=" + id);

		List<DroneComment> droneComments = droneCommentManager.findAllDroneCommentByDroneId(id);

		// no comments (empty, null list) is ok
		if (null == droneComments) {
			LOGGER.log(Level.INFO, this.getClass().getName()
					+ " >No DroneComments found for findAllDroneCommentByDroneId(" + id + ").");
		}

		return new ResponseEntity<List<DroneComment>>(droneComments, HttpStatus.OK);
	}

}
