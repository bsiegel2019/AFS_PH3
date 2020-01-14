package com.drones.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	private DroneCommentManager droneCommentManager; // Service which will do all data retrieval/manipulation work for
														// comment

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView droneComment(@PathVariable("id") Long id) {
		return new ModelAndView("droneComment", "DroneComment", id);
	}

	// -------------------Retrieve All (any) Comments for a Drone----------
	@RequestMapping(value = "/droneComments/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<DroneComment>> findAllDroneCommentByDroneId(@PathVariable("id") Long id) {

		List<DroneComment> droneComments = droneCommentManager.findAllDroneCommentByDroneId(id);

		// no comments (empty, null list) is ok but log info about it
		if (null == droneComments) {
			LOGGER.log(Level.INFO, " >No DroneComments found for findAllDroneCommentByDroneId(" + id + ").");
		}
		return new ResponseEntity<List<DroneComment>>(droneComments, HttpStatus.OK);
	}

	// -------------------Retrieve a Comment by comment id----------
	@RequestMapping(value = "/droneComment/{id}", method = RequestMethod.GET)
	public ResponseEntity<DroneComment> findDroneCommentByCommentId(@PathVariable("id") Long id) {

		DroneComment droneComment = droneCommentManager.findDroneCommentByCommentId(id);

		// no comments (empty, null list) is ok but log info about it
		if (null == droneComment) {
			LOGGER.log(Level.INFO, " >No DroneComment found for findDroneCommentByCommentId(" + id + ").");
		}
		return new ResponseEntity<DroneComment>(droneComment, HttpStatus.OK);
	}

	// -------------------Delete a Comment by comment id----------
	@RequestMapping(value = "/droneCommentDelete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<DroneComment> deleteDroneCommentByCommentId(@PathVariable("id") Long id) {

		Long returnedCommentDeleteRowCount = droneCommentManager.deleteDroneCommentByCommentId(id);

		// we expect 1, 0 or anything else is bad
		if (1 == returnedCommentDeleteRowCount) {
			return new ResponseEntity<DroneComment>(new DroneComment(), HttpStatus.OK);
		}
		LOGGER.log(Level.SEVERE, " >No DroneComment found for deleteDroneCommentByCommentId(" + id + ").");
		return new ResponseEntity<DroneComment>(new DroneComment(), HttpStatus.BAD_REQUEST);
	}

	// -------------------Add a Comment ----------
	@RequestMapping(value = "/addComment", method = RequestMethod.POST)
	public ResponseEntity<DroneComment> addDroneComment(@RequestBody DroneComment droneComment) {

		DroneComment addReturnedDroneComment = droneCommentManager.addDroneComment(droneComment);

		// the commentId field was null on input and should have been set by hibernate on a successful add
		if (null == addReturnedDroneComment.getCommentId()) {
			LOGGER.log(Level.SEVERE, " >No DroneCommentId found for addDroneCommentId - ADD failed");
			return new ResponseEntity<DroneComment>(addReturnedDroneComment, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return new ResponseEntity<DroneComment>(addReturnedDroneComment, HttpStatus.OK);
	}

	// TODO FIX: edit/update not impl'ed in view/js layers
}
