package com.websystique.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.websystique.spring.model.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

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

	public void saveEmployee(Employee employee) {
		persist(employee);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> findAllEmployees() {
		Criteria criteria = getSession().createCriteria(Employee.class);
		return (List<Employee>) criteria.list();
	}

	public void deleteEmployeeBySsn(String ssn) {
		Query query = getSession().createSQLQuery("delete from Employee where ssn = :ssn");
		query.setString("ssn", ssn);
		query.executeUpdate();
	}

	public Employee findBySsn(String ssn) {
		Criteria criteria = getSession().createCriteria(Employee.class);
		criteria.add(Restrictions.eq("ssn", ssn));
		return (Employee) criteria.uniqueResult();
	}

	public void updateEmployee(Employee employee) {
		getSession().update(employee);
	}

}
