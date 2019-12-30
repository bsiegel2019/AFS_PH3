package com.drones.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

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

//		List<DroneComment> selectedDroneComments = new ArrayList<DroneComment>();
//
//		for (Iterator<DroneComment> iterator = droneComments.iterator(); iterator.hasNext();) {
//			DroneComment examineDroneComment = iterator.next();
//			if (examineDroneComment.getCommentDroneId().equals(commentDroneId)) {
//				selectedDroneComments.add(examineDroneComment);
//			}
//		}
//		return selectedDroneComments;
		return droneCommentDao.findAllDroneCommentByDroneId(commentDroneId);
	}

	// END HIB MODS HERE

	private static final AtomicLong counter = new AtomicLong(); // TODO deleted by ph2

	private static List<DroneComment> droneComments; // TODO deleted by ph2

	static {
		droneComments = populateDummyDroneComments(); // TODO deleted by ph2
	}

	// expected to have null comment id, entry for drone id and comment text
	// NOTE: returns comment with valid comment id and input drone id & text
	@Override
	public DroneComment addDroneComment(DroneComment droneComment) {

		droneComment.setCommentId(counter.incrementAndGet()); // TODO deleted by ph2
		if ("".equals(droneComment.getCommentText())) {
			droneComment.setCommentText("ERROR! not provided - you should not be seeing this");
		}
		droneComments.add(droneComment); // TODO this is the call to dao layer
		return droneComment;
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
		droneComments.add(new DroneComment(counter.incrementAndGet(), new Long(4),
				"Comment A for drone id 4 LOTS OF TEXT ->\\”Well, Prince, so Genoa and Lucca are now just family estates of the Buonapartes. But I warn you, if you don't tell me that this means war, if you still try to defend the infamies and horrors perpetrated by that Antichrist- I really believe he is Antichrist- I will have nothing more to do with you and you are no longer my friend, no longer my 'faithful slave,' as you call yourself! But how do you do? I see I have frightened you- sit down and tell me all the news.\\”\r\n"
						+ "It was in July, 1805, and the speaker was the well-known Anna Pavlovna Scherer, maid of honor and favorite of the Empress Marya Fedorovna. With these words she greeted Prince Vasili Kuragin, a man of high rank and importance, who was the first to arrive at her reception. Anna Pavlovna had had a cough for some days. She was, as she said, suffering from la grippe; grippe being then a new word in St. Petersburg, used only by the elite.\r\n"
						+ "All her invitations without exception, written in French, and delivered by a scarlet-liveried footman that morning, ran as follows:\r\n"
						+ "\\”If you have nothing better to do, Count [or Prince], and if the prospect of spending an evening with a poor invalid is not too terrible, I shall be very charmed to see you tonight between 7 and 10- Annette Scherer.\\”\r\n"
						+ "\\”Heavens! what a virulent attack!\\” replied the prince, not in the least disconcerted by this reception. He had just entered, wearing an embroidered court uniform, knee breeches, and shoes, and had stars on his breast and a serene expression on his flat face. He spoke in that refined French in which our grandfathers not only spoke but thought, and with the gentle, patronizing intonation natural to a man of importance who had grown old in society and at court. He went up to Anna Pavlovna, kissed her hand, presenting to her his bald, scented, and shining head, and complacently seated himself on the sofa.\r\n"
						+ "\r\n" + ""));
		return droneComments;
	}

	// expected to have a valid comment id
	// NOTE: returns 1 comment found by the unique comment id, if none/error then null
	@Override
	public DroneComment findDroneCommentByCommentId(Long commentId) {
		for (DroneComment droneComment : droneComments) {
			if (droneComment.getCommentId().equals(commentId)) {
				return droneComment;
			}
		}
		return null;
	}

	// expected to have a valid comment id
	// NOTE: returns Boolean true ONLY if delete was successful
	@Override
	public Boolean deleteDroneCommentByCommentId(Long commentId) {
		Boolean returnFlag = false; // only set to true when successful delete
		long beforeSize = droneComments.size();

		for (Iterator<DroneComment> iterator = droneComments.iterator(); iterator.hasNext();) {
			DroneComment droneComment = iterator.next();
			if (droneComment.getCommentId().equals(commentId)) {
				iterator.remove();
				break;
			}
		}
		long afterSize = droneComments.size();
		if (afterSize < beforeSize) {
			returnFlag = true;
		}
		return returnFlag;
	}

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
