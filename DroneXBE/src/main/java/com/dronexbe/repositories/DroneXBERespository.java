package com.dronexbe.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.dronexbe.model.Drone;

public interface DroneXBERespository extends CrudRepository<Drone, Long> {

	public List<Drone> findAll();

	public Optional<Drone> findById(Long id);

//   @Query("SELECT e FROM Expense e WHERE e.amount >= :amount")
//   public List<Expense> listItemsWithPriceOver(@Param("amount") float amount);

}
