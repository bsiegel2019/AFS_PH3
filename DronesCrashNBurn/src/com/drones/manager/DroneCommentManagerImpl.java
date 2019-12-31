package com.drones.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drones.model.DroneComment;
import com.drones.service.DroneCommentService;

@Service("droneCommentManager")
public class DroneCommentManagerImpl implements DroneCommentManager {

	@Autowired
	private DroneCommentService droneCommentService;

	public DroneComment addDroneComment(DroneComment droneComment) {
		return droneCommentService.addDroneComment(droneComment);
	}

	public DroneComment updateDroneCommentByCommentId(DroneComment droneComment) {
		return droneCommentService.updateDroneCommentByCommentId(droneComment);
	}

	public DroneComment findDroneCommentByCommentId(Long commentId) {
		return droneCommentService.findDroneCommentByCommentId(commentId);
	}

	public List<DroneComment> findAllDroneCommentByDroneId(Long commentDroneId) {
		return droneCommentService.findAllDroneCommentByDroneId(commentDroneId);
	}

	public Long deleteDroneCommentByCommentId(Long commentId) {
		return droneCommentService.deleteDroneCommentByCommentId(commentId);
	}

}
