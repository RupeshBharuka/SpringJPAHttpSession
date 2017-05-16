package com.spring.jpa.app;

import javax.persistence.Column;

public class Address {
	@Column(name="country")
	private String country;
	
	@Column(name="state")
	private String state;
		
	@Column(name="city")
	private String city;

	
	public Address(){
		this.country = "";
		this.state = "";
		this.city = "";		
	}

	public Address(String country, String state, String city) {
		super();
		this.country = country;
		this.state = state;
		this.city = city;
	}


	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String toString(){
		return "Address[ " +", Country : " +country +", State : " +state +", City : " +city +"]";
	}
}
