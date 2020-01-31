package com.dronexbe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dronexbe.model.DroneComment;
import com.dronexbe.repositories.DroneCommentXBERespository;

@Service("droneCommentService")
public class DroneCommentServiceImpl implements DroneCommentService {

	@Autowired
	private DroneCommentXBERespository droneCommentRepository;

	// expected to have a valid drone id - returns ArrayList of 0..n comments
	public List<DroneComment> findAllDroneCommentByDroneId(Long commentDroneId) {
		return droneCommentRepository.findAllByCommentDroneId(commentDroneId);
	}

	// expected to have a valid comment id
	// NOTE: returns 1 comment found by the unique comment id, if none/error then
	// null
	public DroneComment findDroneCommentByCommentId(Long commentId) {
		Optional<DroneComment> droneCommentX = droneCommentRepository.findById(commentId);
		if (droneCommentX.isPresent()) {
			return droneCommentX.get();
		} else {
			return null;
		}
	}

	// expected to have null comment id, entry for drone id and comment text
	// NOTE: returns comment with valid comment id and input drone id & text
	public DroneComment addDroneComment(DroneComment droneComment) {
		return droneCommentRepository.save(droneComment);
	}

	// expected to have a valid comment id - returns Boolean true ONLY if delete was
	// successful
	public Long deleteDroneCommentByCommentId(Long commentId) {
		// count drone comments before the delete attempt
		Long beforeCnt = new Long(droneCommentRepository.count());

		// it does not return a count
		droneCommentRepository.deleteById(commentId);

		Long afterCnt = new Long(droneCommentRepository.count());

		return (beforeCnt - afterCnt); // if delete ok then = 1
	}

	// expected to have valid comment id entry, entry for drone id and comment text
	// NOTE: returns input comment if write by unique comment id is successful, if
	// none/error then null
	public DroneComment updateDroneComment(DroneComment droneComment) {
		return droneCommentRepository.save(droneComment);
	}

	// uses the drone id to get a list of comments for that drone
	// then returns the count 0-n of those comments for that drone
	public Long howManyDroneComments(Long commentDroneId) {
		List<DroneComment> droneCommentList = droneCommentRepository.findAllByCommentDroneId(commentDroneId);
		return new Long(droneCommentList.size());
	}

}
