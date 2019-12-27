package com.drones.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.drones.dao.DroneDAO;
import com.drones.model.Drone;

@Service("droneService")
@Transactional
public class DroneServiceImpl implements DroneService {

//BEGIN HIB MODS HERE

	@Autowired
	private DroneDAO droneDao;

	public List<Drone> findAllDrones() {
		return droneDao.findAllDrones();
	}

	public Drone findDroneByDroneId(Long id) {
		return droneDao.findDroneByDroneId(id);
	}

// END HIB MODS HERE

	private static final AtomicLong counter = new AtomicLong(); // todo deleted by ph2

	private static List<Drone> drones; // TODO deleted by ph2

	static {
		drones = populateDummyDrones(); // TODO deleted by ph2
	}

//	public List<Drone> findAllDrones() {
//		return drones;
//	}

	public Drone addDrone(Drone drone) {

		drone.setDroneId(counter.incrementAndGet()); // TODO deleted by ph2

		// if the optional field was not provided/null, fill with a meaningful string
		if ("".equals(drone.getDroneSpan())) {
			drone.setDroneSpan("not provided");
		}

		// if the optional field was not provided/null, fill with a meaningful string
		if ("".equals(drone.getDroneStatus())) {
			drone.setDroneStatus("not provided");
		}

		// TODO since I don't have a drone image capability - YET
		String tmpDroneType = drone.getDroneType();
		if (tmpDroneType == null) {
			drone.setDroneImage(Drone.ERRONEOUS_DRONE_TYPE_IMAGE);
		} else {
			switch (tmpDroneType) {
			case "Glider":
				drone.setDroneImage("resources/images/glider_example.jpg");
				break;
			case "Sport":
				drone.setDroneImage("resources/images/sport_example.jpg");
				break;
			case "Rotorcraft":
				drone.setDroneImage("resources/images/rotorcraft_example.jpg");
				break;
			default:
				drone.setDroneImage(Drone.ERRONEOUS_DRONE_TYPE_IMAGE);
				break;
			}
		}
		drones.add(drone); // TODO this is the call to dao layer

		return drone; // TODO need since ph2 does db add and it sets ID
	}

	private static List<Drone> populateDummyDrones() {
		List<Drone> drones = new ArrayList<Drone>();
		drones.add(new Drone(counter.incrementAndGet(), "Eagle Ed", "Super Sportster", "Sport", "60 in",
				"crashed, not fixable - one comment for dummy 1", "resources/images/sport_example.jpg"));
		drones.add(new Drone(counter.incrementAndGet(), "Crash Siegel", "Clound Bound", "Glider", "4 meter",
				"repaired - no comment for dummy 2", "resources/images/glider_example.jpg"));
		drones.add(new Drone(counter.incrementAndGet(), "Mr. NoBody", "Lawn Mower", "Rotorcraft", "4x12 in",
				"Flying ballistically - two comments for dummy 3", "resources/images/rotorcraft_example.jpg"));
		drones.add(new Drone(counter.incrementAndGet(), "Talker", "Big Text", "Glider", "too much text	",
				"Hot air - one BIG comment for dummy 4", "resources/images/glider_example.jpg"));
		return drones;
	}

	public void deleteDroneById(Long id) {

		for (Iterator<Drone> iterator = drones.iterator(); iterator.hasNext();) {
			Drone drone = iterator.next();
			if (drone.getDroneId() == id) {
				iterator.remove();
				break;
			}
		}
	}

}
