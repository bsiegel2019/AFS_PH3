package com.drones.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.drones.dao.DroneCommentDAO;
import com.drones.model.DroneComment;

@Service("droneCommentService")
@Transactional
public class DroneCommentServiceImpl implements DroneCommentService {

	// BEGIN HIB MODS HERE

	@Autowired
	private DroneCommentDAO droneCommentDao;

	// expected to have a valid drone id
	// NOTE: returns ArrayList of 0..n comments
	@Override
	public List<DroneComment> findAllDroneCommentByDroneId(Long commentDroneId) {
		return droneCommentDao.findAllDroneCommentByDroneId(commentDroneId);
	}

	// expected to have a valid comment id
	// NOTE: returns 1 comment found by the unique comment id, if none/error then null
	@Override
	public DroneComment findDroneCommentByCommentId(Long commentId) {
		return droneCommentDao.findDroneCommentByCommentId(commentId);
	}

	// expected to have null comment id, entry for drone id and comment text
	// NOTE: returns comment with valid comment id and input drone id & text
	@Override
	public DroneComment addDroneComment(DroneComment droneComment) {
		return droneCommentDao.addDroneComment(droneComment);
	}

	// expected to have a valid comment id
	// NOTE: returns Boolean true ONLY if delete was successful
	@Override
	public Long deleteDroneCommentByCommentId(Long commentId) {
		return droneCommentDao.deleteDroneCommentByCommentId(commentId);
	}

	// END HIB MODS HERE

	private static List<DroneComment> droneComments; // TODO deleted by ph2

	// expected to have valid comment id entry, entry for drone id and comment text
	// NOTE: returns input comment if write by unique comment id is successful, if none/error then null
	@Override
	public DroneComment updateDroneCommentByCommentId(DroneComment droneComment) {
		DroneComment returnComment = null; // only set to droneComment when successful update

		for (int commentIndex = 0; commentIndex < droneComments.size(); commentIndex++) {
			if ((droneComments.get(commentIndex).getCommentId()).equals(droneComment.getCommentId())) {
				droneComments.set(commentIndex, droneComment);
				returnComment = droneComment;
				break;
			}
		}
		return returnComment;
	}

}
