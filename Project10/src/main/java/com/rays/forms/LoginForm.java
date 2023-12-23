package com.rays.forms;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class LoginForm {
	
	@Email
	@NotEmpty(message = "LoginId should not be empty!!!!")
	private String loginId;
	
	@NotEmpty(message = "Password should not be empty!!!!")
	private String password;

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
