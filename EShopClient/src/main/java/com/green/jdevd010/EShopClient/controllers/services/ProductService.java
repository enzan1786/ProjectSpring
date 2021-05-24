package com.green.jdevd010.EShopClient.controllers.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.green.jdevd010.EShopClient.daos.ProductRepository;
import com.green.jdevd010.EShopClient.daos.RoleRepository;
import com.green.jdevd010.EShopClient.models.Product;
import com.green.jdevd010.EShopClient.models.Roles;

@Service
@Transactional
public class ProductService {
	@Autowired
	private ProductRepository repo;

	public List<Product> getAllProduct() {
		return repo.findAll();
	}
	
	public void addLatest(Product product) {
		repo.save(product);
	}
	
	public Product get(Integer id) {
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
