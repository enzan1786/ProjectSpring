package com.green.jdevd010.CoffeeMintClient.controllers.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.green.jdevd010.CoffeeMintClient.daos.UserRepository;
import com.green.jdevd010.CoffeeMintClient.models.User;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public User getUserByUsername(String username) {
		return repo.getUserByUsername(username);
	}
	public List<User> getAllUser() {
		return repo.findAll();
	}
	
	public void addUser(User user) {
		repo.save(user);
	}
	
	public User get(Integer id) {
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
