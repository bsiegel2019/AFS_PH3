package com.drones.dao;

import java.util.List;

import com.drones.model.DroneComment;

public interface DroneCommentDAO {

	List<DroneComment> findAllDroneCommentByDroneId(Long commentDroneId);

	DroneComment findDroneCommentByCommentId(Long commentId);

	DroneComment addDroneComment(DroneComment droneComment);

	Long deleteDroneCommentByCommentId(Long commentId);

}
