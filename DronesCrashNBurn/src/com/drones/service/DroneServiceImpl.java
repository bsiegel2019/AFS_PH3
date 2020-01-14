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

		// TODO remove - fix this date issue
		// fixes TZ regradless of where input/where output
		drone.setDroneFirstFlownDate(
				new Date(drone.getDroneFirstFlownDate().getTime() + new Date().getTimezoneOffset() * 60 * 1000));

		return droneDao.addDrone(drone);
	}

	public Long deleteDroneById(Long id) {
		return droneDao.deleteDroneById(id);
	}

}
