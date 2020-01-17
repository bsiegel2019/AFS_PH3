package com.drones.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "DRONE_COMMENT")
public class DroneComment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long commentId;

	@Column(name = "DRONE_ID", nullable = false)
	private Long commentDroneId;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name = "COMMENT_DATE")
	private Date commentDate;

	@Column(name = "DRONE_COMMENT_TEXT", nullable = false)
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

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
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
		return "DroneComment [commentId=" + commentId + ", commentDroneId=" + commentDroneId + ", commentDate="
				+ commentDate + ", commentText=" + commentText + "]";
	}

}
