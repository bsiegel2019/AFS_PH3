package com.drones.service;

import java.util.List;

import com.drones.model.DroneComment;

public interface DroneCommentService {

	// expected to have a valid drone id
	List<DroneComment> findAllDroneCommentByDroneId(Long commentDroneId); // TODO HIB FIRST

	// expected to have a valid comment id
	DroneComment findDroneCommentByCommentId(Long commentId); // TODO HIB SECOND

	// expected to have null comment id, entry for drone id and comment text
	DroneComment addDroneComment(DroneComment droneComment); // TODO HIB THIRD - not proven

	// expected to have a valid comment id
	Long deleteDroneCommentByCommentId(Long commentId); // TODO HIB FOURTH

	// expected to have valid comment id entry, entry for drone id and comment text
	DroneComment updateDroneCommentByCommentId(DroneComment droneComment);

}
