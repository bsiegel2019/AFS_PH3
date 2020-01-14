package com.drones.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.drones.model.DroneComment;

@Repository("droneCommentDao")
public class DroneCommentDAOImpl implements DroneCommentDAO {

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
	@SuppressWarnings("unchecked") // the cast from List to List<DroneComment>
	public List<DroneComment> findAllDroneCommentByDroneId(Long commentDroneId) {
		Criteria criteria = getSession().createCriteria(DroneComment.class);
		criteria.add(Restrictions.eq("commentDroneId", commentDroneId));
		return (List<DroneComment>) criteria.list();
	}

	@Override
	public DroneComment findDroneCommentByCommentId(Long commentId) {
		Criteria criteria = getSession().createCriteria(DroneComment.class);
		criteria.add(Restrictions.eq("commentId", commentId));
		return (DroneComment) criteria.uniqueResult();
	}

	@Override
	public DroneComment addDroneComment(DroneComment droneComment) {
		persist(droneComment);
		return droneComment;
	}

	@Override
	public Long deleteDroneCommentByCommentId(Long commentId) {
		Query query = getSession().createSQLQuery("delete from drone_comment where commentId = :commentId");
		query.setString("commentId", String.valueOf(commentId));
		return new Long(query.executeUpdate()); // we expect 0 or 1
	}

	// TODO FIX: edit/update not impl'ed in view/js layers
}
