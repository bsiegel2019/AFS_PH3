package com.drones.service;

import java.util.List;

import com.drones.model.DroneComment;

public interface DroneCommentService {

	// expected to have null comment id, entry for drone id and comment text
	DroneComment addDroneComment(DroneComment droneComment);

	// expected to have valid comment id entry, entry for drone id and comment text
	DroneComment updateDroneCommentByCommentId(DroneComment droneComment);

	// expected to have a valid comment id
	DroneComment findDroneCommentByCommentId(Long commentId);

	// expected to have a valid drone id
	List<DroneComment> findAllDroneCommentByDroneId(Long commentDroneId);

	// expected to have a valid comment id
	Boolean deleteDroneCommentByCommentId(Long commentId);

}
