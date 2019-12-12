package com.drones.model;

public class DroneComment {

// 	Comments are related to Drones via a 0..n relationship 
// 	Comments are (Service memory object) 
//		private static List<Drone> drones;  // todo deleted by ph2
//	Comments have a unique sequential Id field - this allows
//	 	"findAllCommentsForDrone(Long commentDroneId)" // returns 0..n comments for that drone, if 0 then empty list
// 		"deleteAllCommentsForDrone(Long commentDroneId)" // deletes 0..n comments for that drone, returns boolean (only true if delete functioned ok)
//		"addCommentForDrone(Long commentDroneId, String commentText)" // adds a comment using a unique sequential commentId, returns a Comment with id or null if fail
//		"updateCommentForDrone(Long commentId, Long commentDroneId, String commentText)" // adds a comment using a unique sequential commentId, returns a Comment or null if fail

	private Long commentId;
	private Long commentDroneId;
	private String commentText;

	public DroneComment() {
	}

	public DroneComment(Long commentId, Long droneId, String commentText) {
		this.commentId = commentId;
		this.commentDroneId = droneId;
		this.commentText = commentText;
	}

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public Long getCommentDroneId() {
		return commentDroneId;
	}

	public void setCommentDroneId(Long commentDroneId) {
		this.commentDroneId = commentDroneId;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (commentDroneId ^ (commentDroneId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (null == obj)
			return false;
		if (!(obj instanceof DroneComment))
			return false;
		DroneComment otherComment = (DroneComment) obj;
		if (commentDroneId != otherComment.commentDroneId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DroneComment [commentId=" + commentId + ", commentDroneId=" + commentDroneId + ", commentText="
				+ commentText + "]";
	}

}
