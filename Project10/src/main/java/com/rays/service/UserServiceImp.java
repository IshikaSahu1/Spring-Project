package com.rays.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.UserDAOImp;
import com.rays.dto.UserDTO;

@Service
public class UserServiceImp implements UserServiceInt{

	@Autowired
	protected UserDAOImp dao;
	
	@Transactional(readOnly = false)
	public long add(UserDTO dto) {
		// TODO Auto-generated method stub
		long id = this.dao.add(dto);
		return id;
	}

	@Transactional(readOnly = false)
	public void update(UserDTO dto) {
		// TODO Auto-generated method stub
		this.dao.update(dto);
	}

	@Transactional(readOnly = false)
	public void delete(UserDTO dto) {
		// TODO Auto-generated method stub
		this.dao.delete(dto);
	}

	@Transactional(readOnly = false)
	public UserDTO findById(int id) {
		// TODO Auto-generated method stub
	UserDTO dto =this.dao.findByPk(id);
		return dto;
	}

	@Transactional(readOnly = false)
	public UserDTO findByLoginId(String login) {
		// TODO Auto-generated method stub
		UserDTO dto =this.dao.findByUniqueKey("email", login);
		return dto;
	}

	@Transactional(readOnly = false)
	public UserDTO authenticate(String login, String password) {
		// TODO Auto-generated method stub
	UserDTO dto = findByLoginId(login);
	
	if(dto!=null) {
		if(password.equals(dto.getPassword())) {
			return dto;
		}
	}
		return null;
	}

	public List search() {
		List dto1 = this.dao.search();
		return dto1;
	}

	

}
