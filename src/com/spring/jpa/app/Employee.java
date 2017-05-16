package com.spring.jpa.app;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
@NamedQueries({
				@NamedQuery(name="Get Employee By Name", query="FROM Employee e WHERE e.empName = :name"),
				@NamedQuery(name="Update Employee By Id", query="UPDATE Employee e SET e.empName= :empName WHERE e.empId= :empId"),
				@NamedQuery(name="Delete Employee By Id", query="DELETE FROM Employee e WHERE e.empId= :empId")
			})
public class Employee {
	
	@Id
	@Column(name="empid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empId;
	
	@Column(name = "empname")
	private String empName;
	
	@Column(name="empaddress", length = 255)
	private String empAddress;

	@Embedded
	private Address address;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "employee_office", 
			   joinColumns = {@JoinColumn(name = "empid")}, 
			   inverseJoinColumns = {@JoinColumn(name="officeid")})
	private Office office;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "employee_phone", 
			   joinColumns = {@JoinColumn(name="empid")}, 
			   inverseJoinColumns = {@JoinColumn(name = "phoneid")})
	List<Phone>listOfPhone;
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "employee_coadingskill", 
			   joinColumns = {@JoinColumn(name = "empid")},
				inverseJoinColumns = {@JoinColumn(name = "skillid")})
	private Set<CoadingSkills>setOfSkills;
	
	
	public Employee(){
		this.empId = 0; //Auto-boxing
		this.empName = "";
		this.empAddress = "";
		this.address = null;
		this.office = null;
	}
		
	public Employee(Integer empId, String empName, String empAddress, Address address, Office office,
			List<Phone> listOfPhone, Set<CoadingSkills> setOfSkills) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAddress = empAddress;
		this.address = address;
		this.office = office;
		this.listOfPhone = listOfPhone;
		this.setOfSkills = setOfSkills;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public List<Phone> getListOfPhone() {
		return listOfPhone;
	}

	public void setListOfPhone(List<Phone> listOfPhone) {
		this.listOfPhone = listOfPhone;
	}

	public Set<CoadingSkills> getSetOfSkills() {
		return setOfSkills;
	}

	public void setSetOfSkills(Set<CoadingSkills> setOfSkills) {
		this.setOfSkills = setOfSkills;
	}

	public String toString(){
		return "Employee Details [" +"Id : " +empId +", Name : " +empName 
				+", Address : " +empAddress +"]";
	}
}
