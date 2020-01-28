package com.dronexbe;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dronexbe.model.Drone;
import com.dronexbe.repositories.DroneXBERespository;

@SpringBootApplication
public class DroneXBE implements CommandLineRunner {

	@Autowired
	DroneXBERespository droneRepository;

	public static void main(String[] args) {
		SpringApplication.run(DroneXBE.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Iterable<Drone> iterator = droneRepository.findAll();
		System.out.println("ERK> All Drones: ");
		iterator.forEach(drone -> System.out.println(drone));

		Long findThis = new Long(2);
		Optional<Drone> droneX = droneRepository.findById(findThis);
		System.out.println("\nERK> A Drone=" + findThis + " >" + droneX);
		findThis = new Long(3);
		droneX = droneRepository.findById(findThis);
		System.out.println("\nERK> A DroneX=" + findThis + " >" + droneX);
		Drone droneY = null;
		if (droneX.isPresent()) {
			droneY = droneX.get();
		} else {
			droneY = new Drone();
		}
		System.out.println("\nERK> A DroneY=" + findThis + " >" + droneY);

		findThis = new Long(987);
		droneX = droneRepository.findById(findThis);
		System.out.println("\nERK> A DroneX=" + findThis + " >" + droneX);
		Drone droneZ = null;
		if (droneX.isPresent()) {
			droneZ = droneX.get();
		} else {
			droneZ = new Drone();
		}
		System.out.println("\nERK> A DroneZ=" + findThis + " >" + droneZ);

		// save a drone?
		Drone testDrone = new Drone(null, "droneOwnerName HAHA", "droneName HAHA", "Glider", "2 inch",
				"crashed and trashed", "resources/images/nu.jpg");
		Long beforeCnt = new Long(droneRepository.count());
		System.out.println("\nERK> BeforeCnt=" + beforeCnt + ", A Drone to SAVE =" + testDrone);
		testDrone = droneRepository.save(testDrone);
		Long duringCnt = new Long(droneRepository.count());
		System.out.println("\nERK>  DuringCnt=" + duringCnt + ", A Drone to SAVED=" + testDrone);
		Long deleteThisId = testDrone.getDroneId();
		droneRepository.deleteById(deleteThisId);
		Long afterCnt = new Long(droneRepository.count());
		Optional<Drone> droneA = droneRepository.findById(deleteThisId);
		System.out.println("\nERK> A DroneA=" + deleteThisId + " >" + droneA);
		System.out.println("\nERK>  AfterCnt=" + afterCnt + ", A Drone DeletED=" + droneA);

	}

}
