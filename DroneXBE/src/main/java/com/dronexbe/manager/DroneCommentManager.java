package com.dronexbe.manager;

import java.util.List;

import com.dronexbe.model.DroneComment;

public interface DroneCommentManager {

	DroneComment addDroneComment(DroneComment droneComment);

	DroneComment updateDroneComment(DroneComment droneComment);

	DroneComment findDroneCommentByCommentId(Long commentId);

	List<DroneComment> findAllDroneCommentByDroneId(Long commentDroneId);

	Long deleteDroneCommentByCommentId(Long commentId);
	
	Long howManyDroneComments(Long commentDroneId);
}
