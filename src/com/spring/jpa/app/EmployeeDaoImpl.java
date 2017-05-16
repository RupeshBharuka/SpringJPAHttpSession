package com.spring.jpa.app;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveEmployeeDetails(Employee employee) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
			session.persist(employee);
		
		transaction.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees() {

		Session session = this.sessionFactory.openSession();
		List<Employee> listOfEmployee = session.createQuery("FROM Employee").list();
		session.close();
	
		return listOfEmployee;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployeeDetailsByName(String name) {
		Session session = sessionFactory.openSession();
		Query query = session.getNamedQuery("Get Employee By Name").setParameter("name", name);
		List<Employee> listOfEmployeeByName = query.list();
		
		return listOfEmployeeByName;
	}

	@Override
	public int updateEmployeeDetails(Integer empId, String empName) {
		Session session = sessionFactory.openSession();
		Query query = session.getNamedQuery("Update Employee By Id");
		query.setParameter("empId", empId);
		query.setParameter("empName", empName);
		
		int noOfRowsUpdated = query.executeUpdate();
		
		return noOfRowsUpdated;
	}

	@Override
	public int deleteEmployeeById(Integer empId) {
		Session session = sessionFactory.openSession();
		Query query = session.getNamedQuery("Delete Employee By Id").setParameter("empId", empId);
		
		int noOfRowsUpdated = query.executeUpdate();
		
		return noOfRowsUpdated;
	}

}
