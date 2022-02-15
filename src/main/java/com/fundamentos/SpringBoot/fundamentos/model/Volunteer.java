package com.fundamentos.SpringBoot.fundamentos.model;

import java.time.LocalDate;

public class Volunteer {
	
	private Long id;
	private Long cityID;
	private String lastname, firstname, email;
	private LocalDate startDate, retirementDate;
	
	public Volunteer(Long id, Long cityID, String lastname, String firstname, String email, LocalDate startDate,
			LocalDate retirementDate) {
		this.id = id;
		this.cityID = cityID;
		this.lastname = lastname;
		this.firstname = firstname;
		this.email = email;
		this.startDate = startDate;
		this.retirementDate = null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCityId() {
		return cityID;
	}

	public void setCityId(Long cityID) {
		this.cityID = cityID;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getRetirementDate() {
		return retirementDate;
	}

	public void setRetirementDate(LocalDate retirementDate) {
		this.retirementDate = retirementDate;
	}	

}
