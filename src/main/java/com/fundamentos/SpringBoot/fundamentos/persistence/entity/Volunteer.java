package com.fundamentos.SpringBoot.fundamentos.persistence.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "voluntarios")
public class Volunteer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_voluntario")
	private Long id;
	
	@Column(name = "sede")
	private Long cityID;
	
	@Column(name = "apeliido")
	private String lastname;
	
	@Column(name = "nombre")
	private String firstname;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "ingreso")
	private LocalDate startDate; 
	
	@Column(name = "baja")
	private LocalDate retirementDate;
	
	public Volunteer () {
	}

	public Volunteer(Long cityID, String lastname, String firstname, String email, LocalDate startDate) {
		this.cityID = cityID;
		this.lastname = lastname;
		this.firstname = firstname;
		this.email = email;
		this.startDate = startDate;
	}
	
	public Volunteer(Long cityID, String lastname, String firstname) {
		this.cityID = cityID;
		this.lastname = lastname;
		this.firstname = firstname;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCityID() {
		return cityID;
	}

	public void setCityID(Long cityID) {
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

	@Override
	public String toString() {
		return "Voluntario/a [apellido=" + lastname + ", nombre=" + firstname + 
				", RP=" + cityID + ", email=" + email + 
				", ingreso=" + startDate + ", baja=" + retirementDate + "]";
	}

}
