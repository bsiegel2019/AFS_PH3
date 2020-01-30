package com.dronexbe.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.dronexbe.model.DroneComment;

public interface DroneCommentXBERespository extends CrudRepository<DroneComment, Long> {

	// TODO service layer needs to translate from Opt to DC...
	// this was: findDroneCommentByCommentId
	public Optional<DroneComment> findById(Long id);

	// added - it returns long, not Long
	long count();

	// this was: findAllDroneCommentByDroneId
	public List<DroneComment> findAllByCommentDroneId(Long drone_id);

	// TODO
	// this is also used for update from the service layer
	@SuppressWarnings("unchecked")
	public DroneComment save(DroneComment droneComment);

	// TODO
	// Long deleteDroneCommentByCommentId(Long commentId); 
	// it does not return a count
	void deleteById(Long id);

}
