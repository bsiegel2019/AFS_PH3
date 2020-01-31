package com.dronexbe.service;

import java.util.List;

import com.dronexbe.model.DroneComment;

public interface DroneCommentService {

	// expected to have a valid drone id
	List<DroneComment> findAllDroneCommentByDroneId(Long commentDroneId);

	// expected to have a valid comment id
	DroneComment findDroneCommentByCommentId(Long commentId);

	// expected to have null comment id, entry for drone id and comment text
	DroneComment addDroneComment(DroneComment droneComment);

	// expected to have a valid comment id
	Long deleteDroneCommentByCommentId(Long commentId);

	// expected to have valid comment id entry, entry for drone id and comment text
	DroneComment updateDroneComment(DroneComment droneComment);
	
	// count how many comments for a drone
	Long howManyDroneComments(Long commentDroneId);
}
