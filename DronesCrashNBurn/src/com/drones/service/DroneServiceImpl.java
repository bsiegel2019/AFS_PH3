package com.drones.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.drones.dao.DroneDAO;
import com.drones.model.Drone;

@Service("droneService")
@Transactional
public class DroneServiceImpl implements DroneService {

	@Autowired
	private DroneDAO droneDao;

	public List<Drone> findAllDrones() {
		return droneDao.findAllDrones();
	}

	public Drone findDroneByDroneId(Long id) {
		return droneDao.findDroneByDroneId(id);
	}

	public Drone addDrone(Drone drone) {
		// if the optional field was not provided/null, fill with a meaningful string
		if ("".equals(drone.getDroneSpan())) {
			drone.setDroneSpan("Not provided");
		}

		// if the optional field was not provided/null, fill with a meaningful string
		if ("".equals(drone.getDroneStatus())) {
			drone.setDroneStatus("Not provided");
		}

		// fixes TZ regradless of where input/where output
		drone.setDroneFirstFlownDate(
				new Date(drone.getDroneFirstFlownDate().getTime() + new Date().getTimezoneOffset() * 60 * 1000));

//		// since I don't have a drone image capability - YET
//		String tmpDroneType = drone.getDroneType();
//		if (tmpDroneType == null) {
//			drone.setDroneImage(Drone.ERRONEOUS_DRONE_TYPE_IMAGE);
//		} else {
//			switch (tmpDroneType) {
//			case "Glider":
//				drone.setDroneImage("resources/images/glider_example.jpg");
//				break;
//			case "Sport":
//				drone.setDroneImage("resources/images/sport_example.jpg");
//				break;
//			case "Rotorcraft":
//				drone.setDroneImage("resources/images/rotorcraft_example.jpg");
//				break;
//			default:
//				drone.setDroneImage(Drone.ERRONEOUS_DRONE_TYPE_IMAGE);
//				break;
//			}
//		}
		return droneDao.addDrone(drone);
	}

	public Long deleteDroneById(Long id) {
		return droneDao.deleteDroneById(id);
	}

}
