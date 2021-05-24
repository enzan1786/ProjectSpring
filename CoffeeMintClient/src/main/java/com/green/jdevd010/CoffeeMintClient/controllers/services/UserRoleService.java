package com.green.jdevd010.CoffeeMintClient.controllers.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.green.jdevd010.CoffeeMintClient.daos.UserRoleRepository;
import com.green.jdevd010.CoffeeMintClient.models.User;
import com.green.jdevd010.CoffeeMintClient.models.UserRole;

@Service
@Transactional
public class UserRoleService {

	@Autowired
	private UserRoleRepository repo;
	
	public List<UserRole> getAllUserRole() {
		return repo.findAll();
	}
	
	public void addUserRole (UserRole userRole) {
		repo.save(userRole);
	}
	
	public UserRole get(Integer id) {
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
