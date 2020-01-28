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

		
//		repository.save(new Expense("breakfast", 5));

//		Iterable<Expense> iterator = repository.findAll();

//		System.out.println("All expense items: ");
//		iterator.forEach(item -> System.out.println(item));

//		List<Expense> breakfast = repository.findByItem("breakfast");
//		System.out.println("\nHow does my breakfast cost?: ");
//		breakfast.forEach(item -> System.out.println(item));

//		List<Expense> expensiveItems = repository.listItemsWithPriceOver(200);
//		System.out.println("\nExpensive Items: ");
//		expensiveItems.forEach(item -> System.out.println(item));

//		List<Expense> apples = repository.findByItem("Some apples");
//		System.out.println("\nHow about them apples: ");
//		System.out.println("How many apples: " + calc_cnt(apples));
//		System.out.println("How costly them apples: " + calc_cost(apples));

	}

//	int calc_cnt(List<Expense> apples) {
//		return apples.size();
//	};
//
//	float calc_cost(List<Expense> apples) {
//		float costX = 0;
//		for (int i = 0; i < apples.size(); i++) {
//			costX = costX + apples.get(i).getAmount();
//		}
//		return costX;
//	};

}
