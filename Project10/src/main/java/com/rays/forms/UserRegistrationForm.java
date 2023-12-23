package com.rays.forms;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UserRegistrationForm {
	
	@NotEmpty(message = "FirstName Should not be empty!!!")
	private String firstName;
	
	@NotEmpty(message = "LastName Should not be empty!!!")
	private String lastName;
	
	@Email
	@NotEmpty(message = "LoginID Should not be empty!!!")
	private String loginID;
	
	@NotEmpty(message = "Password Should not be empty!!!")
	private String password;
	
	@NotEmpty(message = "PhoneNo Should not be empty!!!")
	private String phone;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLoginID() {
		return loginID;
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
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
