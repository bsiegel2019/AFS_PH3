package com.dronexbe.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dronexbe.model.Drone;
import com.dronexbe.repositories.DroneXBERespository;

@Service("droneService")
public class DroneServiceImpl implements DroneService {

	@Autowired
	DroneXBERespository droneRepository;

	// returns a List of drones or an empty list
	public List<Drone> findAllDrones() {
		return droneRepository.findAll();
	}

	// returns a drone if one found by the is OR returns a null 
	// ctrlr deals with this
	public Drone findDroneByDroneId(Long id) {
		Optional<Drone> droneX = droneRepository.findById(id);
		if (droneX.isPresent()) {
			return droneX.get();
		} else {
			return null;
		}
	}

	// returns a drone with an inserted unique id
	@SuppressWarnings("deprecation")
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
		// TODO is this need after FE/BE split?
//		drone.setDroneFirstFlownDate(
//				new Date(drone.getDroneFirstFlownDate().getTime() + new Date().getTimezoneOffset() * 60 * 1000));

		// this save does the add and returns an updated drone with the id
		return droneRepository.save(drone);
	}

	public Long deleteDroneById(Long id) {
		// count drones before the delete attempt
		Long beforeCnt = new Long(droneRepository.count());

		// it does not return a count
		droneRepository.deleteById(id);

		Long afterCnt = new Long(droneRepository.count());

		return (beforeCnt - afterCnt); // if delete ok then = 1
	}

}
