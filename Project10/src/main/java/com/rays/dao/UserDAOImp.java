package com.rays.dao;

import java.util.List;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.dto.	UserDTO;

@Repository
public class UserDAOImp implements UserDAOInt {

	@PersistenceContext
     protected EntityManager entity;

	@Override
	public long add(UserDTO dto) {
		// TODO Auto-generated method stub
		entity.persist(dto);
		
		return dto.getId();
	}

	@Override
	public void update(UserDTO dto) {
		entity.merge(dto);
		
	}	
	
	@Override
	public UserDTO findByPk(int id) {
		UserDTO userDto = this.entity.find(UserDTO.class, id);
		return userDto;
	}

	@Override
	public void delete(UserDTO dto) {
		this.entity.remove(dto);
		
	}

	@Override
	public UserDTO findByUniqueKey(String attribute, Object value) {
		
		CriteriaBuilder builder = this.entity.getCriteriaBuilder();
		
		CriteriaQuery<UserDTO> cq = builder.createQuery(UserDTO.class);
		
		Root<UserDTO> qRoot = cq.from(UserDTO.class);
		
		Predicate condition = builder.equal(qRoot.get(attribute),value);
		
		cq.where(condition);
		
		TypedQuery<UserDTO> query = entity.createQuery(cq);
		
		List<UserDTO> list = query.getResultList();
		
		UserDTO dto = null;
		
		if(list.size()>0) {
			dto = list.get(0);
		}
		
		return dto;
	}

	public List search() {
		
		CriteriaBuilder builder = this.entity.getCriteriaBuilder();
		
		CriteriaQuery<UserDTO> cq = builder.createQuery(UserDTO.class);
		
		Root<UserDTO> qRoot = cq.from(UserDTO.class);

		cq.select(qRoot);
		
		TypedQuery<UserDTO> query = entity.createQuery(cq);
		
		List<UserDTO> list = query.getResultList();
		
		return list;
	
	}
}
