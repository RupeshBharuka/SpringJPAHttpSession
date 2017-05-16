package com.spring.jpa.app;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplication {
	
	private static Scanner scan;
	private static Integer empId;
	private static Integer noOfRowsAffected; 
	private static List<Employee>listOfEmployee; 
	
	private static boolean validateInput(String input){
		return input.matches("[a-zA-Z]+");
	}
	
	private static boolean checkIfRowAffected(int noOfRowsAffected) {
		return noOfRowsAffected > 0;
	}

	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		EmployeeDao employeeDao = context.getBean(EmployeeDao.class);
		
		scan = new Scanner(System.in);
		
		System.out.println("--- Menu ---");
		System.out.println("1. Insert Employee Details");
		System.out.println("2. Display All Employee Details");
		System.out.println("3. Get Employee Details By Name");
		System.out.println("4. Update Employee Details");
		System.out.println("5. Delete Employee Details");
		System.out.println("6. Exit");
		System.out.println("------------");
		
		System.out.println("Enter your choice(1/2/3/4/5/6): ");
		String input = scan.next();
		
		if(!validateInput(input)){
			int choice = Integer.parseInt(input);
			
			switch(choice){
				case 1:
					Address address = new Address("India", "Maharashtra", "Pune");
					
					Office office = new Office("Apple", "Banglore");
					Office office2 = new Office("Google", "USA");
					
					Phone phone1 = new Phone("9584756532", "DOCOMO");
					Phone phone2 = new Phone("9958654875", "Vodafone");
					List<Phone>listOfPhones = new ArrayList<>();
					
					listOfPhones.add(phone1);
					listOfPhones.add(phone2);
					
					Set<CoadingSkills>setOfSkills = new HashSet<>();
					setOfSkills.add(new CoadingSkills("java 7", "C#", "Python"));
					setOfSkills.add(new CoadingSkills("java 8", "ASP", "Python"));
					
					
					Employee employee = new Employee();
					employee.setEmpName("Rupesh");
					employee.setEmpAddress("Akurdi");
					employee.setAddress(address);
					employee.setOffice(office);
					employee.setListOfPhone(listOfPhones);
					employee.setSetOfSkills(setOfSkills);
															
					employeeDao.saveEmployeeDetails(employee);
					
					
					// creating 2nd employee
					Employee employee2 = new Employee();
					employee2.setEmpName("Vishal");
					employee2.setEmpAddress("Akurdi");
					employee2.setAddress(address);
//					employee2.setOffice(office);   //Exception : We are assigning same office to 2 different employees
					employee2.setOffice(office2); 
					
					employeeDao.saveEmployeeDetails(employee2);
					
					break;
				
				case 2:
					System.out.println("----- List of Employees -----");
					listOfEmployee = employeeDao.getAllEmployees();
					
					//java-8 forEach loop
					listOfEmployee.forEach(System.out::println);
					break;
					
				case 3:

					System.out.println("----- List of Employees By Same Name -----");
					listOfEmployee = employeeDao.getEmployeeDetailsByName("Rupesh");

					//java-8 forEach loop
					listOfEmployee.forEach(System.out::println);
					break;
				
				case 4:
					System.out.println("Enter Employee Id : ");
					empId = scan.nextInt();
					
					noOfRowsAffected = employeeDao.updateEmployeeDetails(empId, "Shubham");
					
					if(checkIfRowAffected(noOfRowsAffected)){
						System.out.println("Record updated successfully..!");
					}else{
						System.out.println("Sorry ! Record can not be updated..!");
					}
					break;
					
				case 5:
					System.out.println("Enter Employee Id : ");
					empId = scan.nextInt();
					
					noOfRowsAffected = employeeDao.deleteEmployeeById(empId);
					
					if(checkIfRowAffected(noOfRowsAffected)){
						System.out.println("Record deleted successfully..!");
					}else{
						System.out.println("Sorry ! Record can not be deleted..!");
					}
					break;
					
				case 6:
					System.exit(0);
				
				default:
					System.err.println("Error ! Invalid Choice..!");
					System.exit(0);
			}
			
		}else{
			System.err.println("Error ! Enter only Digits");
			System.exit(1);
		}
					
	}// end of main() method
	
}
