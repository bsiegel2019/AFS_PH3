package com.dronexbe.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.dronexbe.model.DroneComment;

public interface DroneCommentXBERespository extends CrudRepository<DroneComment, Long> {

	//
//	DroneComment addDroneComment(DroneComment droneComment);
//
//	Long deleteDroneCommentByCommentId(Long commentId);
//
//	DroneComment updateDroneComment(DroneComment droneComment);
	//

	// TODO service layer needs to translate from Opt to DC...
	// this was: findDroneCommentByCommentId
	public Optional<DroneComment> findById(Long id);

	// added - it returns long, not Long
	long count();

	// this was: findAllDroneCommentByDroneId
	public List<DroneComment> findAllByCommentDroneId(Long drone_id);

	// below is drone repo stuff

//	//	List<Drone> findAllDrones(); - this from DroneDAO	
//	public List<Drone> findAll();
//
//	//	Drone addDrone(Drone drone); - this from DroneDAO
//	 @SuppressWarnings("unchecked")
//	public Drone save(Drone drone);
//
//	 //	Long deleteDroneById(Long id); - it does not return a count
//	 void deleteById(Long id);
//	

// TODO remove garbage below
//	@Override
//	public DroneComment addDroneComment(DroneComment droneComment) {
//		persist(droneComment);
//		return droneComment;
//	}
//
//	@Override
//	public Long deleteDroneCommentByCommentId(Long commentId) {
//		Query query = getSession().createSQLQuery("delete from drone_comment where commentId = :commentId");
//		query.setString("commentId", String.valueOf(commentId));
//		return new Long(query.executeUpdate()); // we expect 0 or 1
//	}
//
//	@Override
//	public DroneComment updateDroneComment(DroneComment droneComment) {
//		update(droneComment);
//		return droneComment;
//	}

}
