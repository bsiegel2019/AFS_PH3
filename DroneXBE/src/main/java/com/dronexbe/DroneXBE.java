package com.dronexbe;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dronexbe.model.Drone;
import com.dronexbe.model.DroneComment;
import com.dronexbe.repositories.DroneCommentXBERespository;
import com.dronexbe.repositories.DroneXBERespository;

@SpringBootApplication
public class DroneXBE implements CommandLineRunner {

	@Autowired
	DroneXBERespository droneRepository;

	@Autowired
	DroneCommentXBERespository droneCommentRepository;

	public static void main(String[] args) {
		SpringApplication.run(DroneXBE.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		boolean testDroneProcesses = false;
		if (testDroneProcesses) {
			Long beginCnt =  droneRepository.count();
			System.out.println("ERK> BEGIN All Drones: " + beginCnt);

			Iterable<Drone> iterator = droneRepository.findAll();
			System.out.println("ERK> All Drones: ");
			iterator.forEach(drone -> System.out.println(drone));

			Long findThis = new Long(2);
			Optional<Drone> droneX = droneRepository.findById(findThis);
			System.out.println("\nERK> A Drone=" + findThis + " >" + droneX);
			findThis = new Long(1);
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
			
			Long endCnt =  droneRepository.count();
			System.out.println("ERK>  END  All Drones: " + endCnt);
		} else {
			System.out.println("\nERK> Skipping Drone Tests");			
		}

		boolean testDroneCommentProcesses = false;
		if (testDroneCommentProcesses) {
			Long beginCommentCnt =  droneCommentRepository.count();
			System.out.println("ERK> BEGIN All Drone Comments: " + beginCommentCnt);

			System.out.println("\nZERK> begin DroneComment");
			Long findThisComment = new Long(5);
			Optional<DroneComment> droneCommentX = droneCommentRepository.findById(findThisComment);
			System.out.println("\nZERK> A DroneComment=" + findThisComment + " >" + droneCommentX);
			Long commentXCnt = new Long(droneCommentRepository.count());
			System.out.println("\nZERK> commentXCnt=" + commentXCnt);

			Long drone_id = new Long(1);
			List<DroneComment> DCList = droneCommentRepository.findAllByCommentDroneId(drone_id);
			System.out.println("ZERK> All Drone Comments for: " + drone_id + ">>" + DCList);
			
			// save a drone comment?
			DroneComment testDroneComment = new DroneComment(null, new Long(3), new Date(), "ARGH! COMMENT TEXT");
			Long beforeCommentCnt = new Long(droneCommentRepository.count());
			System.out.println("\nZERK> beforeCommentCnt=" + beforeCommentCnt + ", A Drone Comment to SAVE =" + testDroneComment);
			testDroneComment = droneCommentRepository.save(testDroneComment);
			Long duringCommentCnt = new Long(droneCommentRepository.count());
			System.out.println("\nZERK>  duringCommentCnt=" + duringCommentCnt + ", A Drone Comment to SAVED=" + testDroneComment);
			
			String textToUpdate = "OMG! UPDATED COMMENT TEXT";
			testDroneComment.setCommentText(textToUpdate);
			testDroneComment = droneCommentRepository.save(testDroneComment);
			
			//retrieve updated comment
			findThisComment = testDroneComment.getCommentId();
			Optional<DroneComment> droneCommentUpdatedOpt = droneCommentRepository.findById(findThisComment);
			DroneComment droneCommentUpdated = droneCommentUpdatedOpt.get();
			if (new String(textToUpdate).contentEquals(new String(droneCommentUpdatedOpt.get().getCommentText()))) {
				System.out.println("\nZERK>  A Drone Comment to UPDATE WORKED=" + new String(droneCommentUpdatedOpt.get().getCommentText()));
			} else {
				System.out.println("\nZERK>  A Drone Comment to UPDATE FAILED=" + droneCommentUpdatedOpt.get().getCommentText() + ", should have been=" + textToUpdate);				
			}
			System.out.println("\nZERK> Update=" + testDroneComment);
			System.out.println("\nZERK>  Found=" + droneCommentUpdated);
			
			Long deleteThisCommentId = droneCommentUpdated.getCommentId();
			droneCommentRepository.deleteById(deleteThisCommentId);
			Long afterCommentCnt = new Long(droneCommentRepository.count());
			Optional<DroneComment> droneCommentA = droneCommentRepository.findById(deleteThisCommentId);
			System.out.println("\nERK> A DroneCommentA=" + deleteThisCommentId + " >" + droneCommentA);
			System.out.println("\nERK>  AfterCommentCnt=" + afterCommentCnt + ", A Drone Comment DeletED=" + droneCommentA);
	
			Long endCommentCnt =  droneCommentRepository.count();
			System.out.println("ERK>  END  All Drones: " + endCommentCnt);		
		} else {
			System.out.println("\nZERK> Skipping Drone Comment Tests");			
		}

	}

}
