package com.spring.jpa.app;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="office")
public class Office {
	
	@Id
	@Column(name = "officeid")
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Integer officeId;
	
	@Column(name="officename")
	private String officeName;
	
	@Column(name="officelocation")
	private String officeLocation;

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Employee employee;
	
	public Office(){
		this.officeId = 0;
		this.officeName = "";
		this.officeLocation = "";
	}
	
	public Office(String officeName, String officeLocation) {
		this.officeName = officeName;
		this.officeLocation = officeLocation;
	}

	public Integer getOfficeId() {
		return officeId;
	}

	public void setOfficeId(Integer officeId) {
		this.officeId = officeId;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public String getOfficeLocation() {
		return officeLocation;
	}

	public void setOfficeLocation(String officeLocation) {
		this.officeLocation = officeLocation;
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String toString(){
		return "Office [" +"Id : " +officeId +", Name : " +officeName +", Location : " +officeLocation +"]";
	}
	
}
