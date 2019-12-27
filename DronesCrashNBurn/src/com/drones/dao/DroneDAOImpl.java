package com.drones.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.drones.model.Drone;

@Repository("droneDao")
public class DroneDAOImpl implements DroneDAO {

	// BEGIN copied in from abstractdao
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void persist(Object entity) {
		getSession().persist(entity);
	}

	public void delete(Object entity) {
		getSession().delete(entity);
	}
	// END copied in from abstractdao

	@Override
	@SuppressWarnings("unchecked") // the cast from List to List<Drone>
	public List<Drone> findAllDrones() {
		Criteria criteria = getSession().createCriteria(Drone.class);
		return (List<Drone>) criteria.list();
	}

	@Override
	public Drone findDroneByDroneId(Long id) {
		Criteria criteria = getSession().createCriteria(Drone.class);
		criteria.add(Restrictions.eq("droneId", id));
		return (Drone) criteria.uniqueResult();
	}

	@Override
	public Drone addDrone(Drone drone) {
		persist(drone);
		return drone;
	}

}
