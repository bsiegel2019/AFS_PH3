package com.drones.manager;

import java.util.List;

import com.drones.model.DroneComment;

public interface DroneCommentManager {

	DroneComment addDroneComment(DroneComment droneComment);

	DroneComment updateDroneCommentByCommentId(DroneComment droneComment);

	DroneComment findDroneCommentByCommentId(Long commentId);

	List<DroneComment> findAllDroneCommentByDroneId(Long commentDroneId);

	Boolean deleteDroneCommentByCommentId(Long commentId);

}
