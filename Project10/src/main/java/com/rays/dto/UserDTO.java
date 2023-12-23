package com.rays.dto;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ST_USER")
public class UserDTO {
	
	@Id
	@GeneratedValue
	@GenericGenerator(name = "ncsPK" , strategy = "native")
	@Column(name = "ID" , unique = true , nullable = false)
	private int id;
	
	@Column(name = "FIRST_NAME" , length = 50)
	private String firstname;
	
	@Column(name = "LAST_NAME" , length = 50)
	private String lastname;
	
	@Column(name = "EMAIL" , length = 100)
	private String email;
	
	@Column(name = "PASSWORD" , length = 50)
	private String password;
	
	@Column(name = "PHONE" , length = 10)
	private String phone;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	
}
