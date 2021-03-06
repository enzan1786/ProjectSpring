package com.green.jdevd010.EShopClient.controllers.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.green.jdevd010.EShopClient.daos.RoleRepository;
import com.green.jdevd010.EShopClient.models.Roles;
import com.green.jdevd010.EShopClient.models.User;

@Service
@Transactional
public class RoleService {
	@Autowired
	private RoleRepository repo;

	public List<Roles> getAllRoles() {
		return repo.findAll();
	}
	
	public void addRoles(Roles role) {
		repo.save(role);
	}
	
	public Roles get(Integer id) {
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
