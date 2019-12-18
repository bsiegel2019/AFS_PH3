package com.drones.model;

public class DroneComment {

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
