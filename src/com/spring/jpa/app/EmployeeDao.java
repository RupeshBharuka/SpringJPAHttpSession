package com.spring.jpa.app;

import java.util.List;

public interface EmployeeDao {
	public void saveEmployeeDetails(Employee employee);
	
	public List<Employee> getAllEmployees();
	
	public List<Employee> getEmployeeDetailsByName(String name);
	
	public int updateEmployeeDetails(Integer empId, String empName);
	
	public int deleteEmployeeById(Integer empId);
}
