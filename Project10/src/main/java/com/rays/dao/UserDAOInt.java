package com.rays.dao;

import com.rays.dto.UserDTO;

public interface UserDAOInt {
	
	public long add(UserDTO dto);
	
	public void update(UserDTO dto);
	
	public void delete(UserDTO dto);
	
	public UserDTO findByPk(int id);
	
	public UserDTO findByUniqueKey(String attribute,Object val);

}
