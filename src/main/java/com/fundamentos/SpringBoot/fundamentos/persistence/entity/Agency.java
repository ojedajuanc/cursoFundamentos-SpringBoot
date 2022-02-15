package com.fundamentos.SpringBoot.fundamentos.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sede")
public class Agency {

	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_sede")
	private Long id;
	
	@Column(name = "ciudad", nullable = false, unique = true)
	private String name;
	
	@Column(name = "punto_venta")
	private Long internalCode;
	
	@Column(name = "contacto")
	private String contactEmail;
	
	public Agency() {
	}

	public Agency(String name, Long internalCode, String contactEmail) {
		this.name = name;
		this.internalCode = internalCode;
		this.contactEmail = contactEmail;
	}
	
	public Agency(Long internalCode, String conctactEmail) {
		this.internalCode = internalCode;
		this.contactEmail = conctactEmail;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getInternalCode() {
		return internalCode;
	}

	public void setInternalCode(Long internalCode) {
		this.internalCode = internalCode;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	@Override
	public String toString() {
		return "Agency [id=" + id + ", name=" + name + ", internalCode=" + internalCode + ", contactEmail="
				+ contactEmail + "]";
	}
		
	
}
