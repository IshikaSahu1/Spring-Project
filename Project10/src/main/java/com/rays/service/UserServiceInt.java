package com.rays.service;

import com.rays.dto.UserDTO;

public interface UserServiceInt {

	public long add(UserDTO dto);
	
	public void update(UserDTO dto);
	
	public void delete(UserDTO dto);
	
	public UserDTO findById(int id);
	
	public UserDTO findByLoginId(String login);
	
	public UserDTO authenticate(String login,String password);
}
