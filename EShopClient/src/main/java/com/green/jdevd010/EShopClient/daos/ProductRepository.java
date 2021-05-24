package com.green.jdevd010.EShopClient.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.jdevd010.EShopClient.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
