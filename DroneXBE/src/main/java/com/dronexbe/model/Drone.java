package com.dronexbe.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "DRONE")
public class Drone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "droneid", nullable = false)
	private Long droneId;

	@Column(name = "DRONE_OWNER_NAME", nullable = false)
	private String droneOwnerName;

	@Column(name = "DRONE_NAME", nullable = false)
	private String droneName;

	@Column(name = "DRONE_TYPE", nullable = false)
	private String droneType;

	@Column(name = "DRONE_SPAN")
	private String droneSpan;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name = "DRONE_FIRST_FLOWN")
	private Date droneFirstFlownDate;

	@Column(name = "DRONE_STATUS")
	private String droneStatus;

	@Column(name = "DRONE_IMAGE")
	private String droneImage;

	public Drone() {
	}

	public Drone(Long droneId, String droneOwnerName, String droneName, String droneType, String droneSpan,
			String droneStatus, String droneImage) {
		this.droneId = droneId;
		this.droneOwnerName = droneOwnerName;
		this.droneName = droneName;
		this.droneType = droneType;
		this.droneSpan = droneSpan;
		this.droneStatus = droneStatus;
		this.droneImage = droneImage;
	}

	public Long getDroneId() {
		return droneId;
	}

	public void setDroneId(Long droneId) {
		this.droneId = droneId;
	}

	public String getDroneOwnerName() {
		return droneOwnerName;
	}

	public void setDroneOwnerName(String droneOwnerName) {
		this.droneOwnerName = droneOwnerName;
	}

	public String getDroneName() {
		return droneName;
	}

	public void setDroneName(String droneName) {
		this.droneName = droneName;
	}

	public String getDroneType() {
		return droneType;
	}

	public void setDroneType(String droneType) {
		this.droneType = droneType;
	}

	public String getDroneSpan() {
		return droneSpan;
	}

	public void setDroneSpan(String droneSpan) {
		this.droneSpan = droneSpan;
	}

	public Date getDroneFirstFlownDate() {
		return droneFirstFlownDate;
	}

	public void setDroneFirstFlownDate(Date droneFirstFlownDate) {
		this.droneFirstFlownDate = droneFirstFlownDate;
	}

	public String getDroneStatus() {
		return droneStatus;
	}

	public void setDroneStatus(String droneStatus) {
		this.droneStatus = droneStatus;
	}

	public String getDroneImage() {
		return droneImage;
	}

	public void setDroneImage(String droneImage) {
		this.droneImage = droneImage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (droneId ^ (droneId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (null == obj)
			return false;
		if (!(obj instanceof Drone))
			return false;
		Drone other = (Drone) obj;
		if (droneId != other.droneId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Drone [droneId=" + droneId + ", droneOwnerName=" + droneOwnerName + ", droneName=" + droneName
				+ ", droneType=" + droneType + ", droneSpan=" + droneSpan + ", " + "droneFirstFlownDate="
				+ droneFirstFlownDate + ", droneStatus=" + droneStatus + ", droneImage=" + droneImage + "]";
	}

}
