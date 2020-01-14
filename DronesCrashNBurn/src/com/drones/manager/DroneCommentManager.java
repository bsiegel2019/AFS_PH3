package com.drones.manager;

import java.util.List;

import com.drones.model.DroneComment;

public interface DroneCommentManager {

	DroneComment addDroneComment(DroneComment droneComment);

	DroneComment updateDroneCommentByCommentId(DroneComment droneComment);

	DroneComment findDroneCommentByCommentId(Long commentId);

	List<DroneComment> findAllDroneCommentByDroneId(Long commentDroneId);

	Long deleteDroneCommentByCommentId(Long commentId);

	// TODO FIX: edit/update not impl'ed in view/js layers
}
