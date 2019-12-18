package com.drones.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.drones.model.DroneComment;

@Service("droneCommentService")
public class DroneCommentServiceImpl implements DroneCommentService {

	private static final AtomicLong counter = new AtomicLong(); // TODO deleted by ph2

	private static List<DroneComment> droneComments; // TODO deleted by ph2

	static {
		droneComments = populateDummyDroneComments(); // TODO deleted by ph2
	}

	// expected to have a valid drone id
	// NOTE: returns ArrayList of 0..n comments
	@Override
	public List<DroneComment> findAllDroneCommentByDroneId(Long commentDroneId) {

		List<DroneComment> selectedDroneComments = new ArrayList<DroneComment>();

		for (Iterator<DroneComment> iterator = droneComments.iterator(); iterator.hasNext();) {
			DroneComment examineDroneComment = iterator.next();
			System.out.println("InSdie A findAllDroneCommentByDroneId where finderid=" + commentDroneId
					+ ", this commentid=" + examineDroneComment.getCommentDroneId()); // TODO
			if (examineDroneComment.getCommentDroneId().equals(commentDroneId)) {
				selectedDroneComments.add(examineDroneComment);
			}
		}
		System.out.println("InSdie B findAllDroneCommentByDroneId where selectedSize=" + selectedDroneComments.size()); // TODO
		return selectedDroneComments;
	}

	// expected to have null comment id, entry for drone id and comment text
	// NOTE: returns comment with valid comment id and input drone id & text
	@Override
	public DroneComment addDroneComment(DroneComment droneComment) {

		droneComment.setCommentId(counter.incrementAndGet()); // TODO deleted by ph2
		if ("".equals(droneComment.getCommentText())) {
			droneComment.setCommentText("ERROR! not provided - you should not be seeing this");
		}

		System.out.println("InSdie A addDroneComment before ADD where Size=" + droneComments.size()); // TODO
		droneComments.add(droneComment); // TODO this is the call to dao layer
		System.out.println("InSdie B addDroneComment  after ADD where Size=" + droneComments.size()); // TODO
		return droneComment; // TODO need since ph2 does db add and it sets ID
	}

	private static List<DroneComment> populateDummyDroneComments() {
		// one comment for dummy 1
		// no comment for dummy 2
		// two comments for dummy 3
		List<DroneComment> droneComments = new ArrayList<DroneComment>();
		droneComments.add(new DroneComment(counter.incrementAndGet(), new Long(1),
				"Comment for drone id 1 Loves this Super Sportster"));
		droneComments.add(new DroneComment(counter.incrementAndGet(), new Long(3),
				"Comment A for drone id 3 Hates this Lawn Mower"));
		droneComments.add(new DroneComment(counter.incrementAndGet(), new Long(3),
				"Comment B for drone id 3 Loves this Lawn Mower"));
		return droneComments;
	}

	// expected to have a valid comment id
	// NOTE: returns 1 comment found by the unique comment id, if none/error then null
	@Override
	public DroneComment findDroneCommentByCommentId(Long commentId) {
		System.out.println("InSdie A findDroneCommentByCommentId where finderid=" + commentId); // TODO
		for (DroneComment droneComment : droneComments) {
			if (droneComment.getCommentId().equals(commentId)) {
				System.out.println("InSdie B findDroneCommentByCommentId where finderid=" + commentId
						+ ", this comment=" + droneComment.toString()); // TODO
				return droneComment;
			}
		}
		System.out.println("InSdie C findDroneCommentByCommentId where finderid=" + commentId
				+ ", found nothing ERROR?! returned null"); // TODO
		return null;
	}

	// expected to have a valid comment id
	// NOTE: returns Boolean true ONLY if delete was successful
	@Override
	public Boolean deleteDroneCommentByCommentId(Long commentId) {
		Boolean returnFlag = false; // only set to true when successful delete
		long beforeSize = droneComments.size();

		System.out.println("InSdie A deleteDroneCommentByCommentId where commentId=" + commentId + ", return Boolean="
				+ returnFlag + ", arraylist size=" + beforeSize); // TODO

		for (Iterator<DroneComment> iterator = droneComments.iterator(); iterator.hasNext();) {
			DroneComment droneComment = iterator.next();
			if (droneComment.getCommentId().equals(commentId)) {
				System.out.println("InSdie B deleteDroneCommentByCommentId where finderid=" + commentId
						+ ", this comment=" + droneComment.toString()); // TODO
				iterator.remove();
				break;
			}
		}
		long afterSize = droneComments.size();
		if (afterSize < beforeSize) {
			returnFlag = true;
		}
		System.out.println("InSdie C deleteDroneCommentByCommentId where commentId=" + commentId + ", return Boolean="
				+ returnFlag + ", arraylist size was=" + beforeSize + ", aftersize=" + afterSize); // TODO

		return returnFlag;
	}

	// expected to have valid comment id entry, entry for drone id and comment text
	// NOTE: returns input comment if write by unique comment id is successful, if none/error then null
	@Override
	public DroneComment updateDroneCommentByCommentId(DroneComment droneComment) {
		DroneComment returnComment = null; // only set to droneComment when successful update

		System.out.println("InSdie A updateDroneCommentByCommentId where update comment=" + droneComment); // TODO

		for (int commentIndex = 0; commentIndex < droneComments.size(); commentIndex++) {
			if ((droneComments.get(commentIndex).getCommentId()).equals(droneComment.getCommentId())) {
				droneComments.set(commentIndex, droneComment);
				returnComment = droneComment;

				System.out.println("InSdie B updateDroneCommentByCommentId where found old comment="
						+ droneComments.get(commentIndex) + ", where index=" + commentIndex); // TODO

				break;
			}
		}

		System.out.println("InSdie C updateDroneCommentByCommentId where returnComment=" + returnComment); // TODO

		return returnComment;
	}

}
