package com.rays.forms;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UserForm {
	
	@NotEmpty(message= "FirstName should not be empty!!")
	private String firstname;
	
	@NotEmpty(message = "LastName should not be empty!!")
	private String lastname;
	
	@Email
	@NotEmpty(message = "LoginId should not be empty!!")
	private String loginId;
	
	@NotEmpty(message = "Password should not be empty!!")
	private String pasword;
	

	@NotEmpty(message = "MobileNo should not be empty!!")
	private String phone ;
	
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

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPasword() {
		return pasword;
	}

	public void setPasword(String pasword) {
		this.pasword = pasword;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


}
