package com.spring.jpa.app;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "phone")
public class Phone {
	
	@Id
	@Column(name = "phoneid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer phoneId;
	
	@Column(name = "phonenumber")
	private String phoneNumber;
	
	@Column(name = "serviceprovider")
	private String serviceProvider;
	
	@ManyToOne
	@JoinColumn(name = "empid")
	private Employee employee;

	public Phone(){
		
	}
	
	public Phone(String phoneNumber, String serviceProvider) {
		this.phoneNumber = phoneNumber;
		this.serviceProvider = serviceProvider;
	}

	public Integer getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(Integer phoneId) {
		this.phoneId = phoneId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(String serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Phone [phoneId=" + phoneId + ", phoneNumber=" + phoneNumber + ", serviceProvider=" + serviceProvider
				+ ", employee=" + employee + "]";
	}
	
}
