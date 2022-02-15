package com.fundamentos.SpringBoot.fundamentos.persistence.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_usuario")
	private Long id;
	
	@Column(name = "nombre")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "nacimiento")
	private LocalDate birthday;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonBackReference
	private List<UserPost> userPosts = new ArrayList<>();

	public User() {
	}

	public User(String name, String email, LocalDate birthday) {
		this.name = name;
		this.email = email;
		this.birthday = birthday;
	}
	
	public User(String name, String email) {
		this.name = name;
		this.email = email;
		this.birthday = LocalDate.now();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public List<UserPost> getUserPosts() {
		return userPosts;
	}

	public void setUserPosts(List<UserPost> userPosts) {
		this.userPosts = userPosts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", birthday=" + birthday + ", userPosts="
				+ userPosts + "]";
	}

}
