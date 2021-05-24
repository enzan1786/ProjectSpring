package com.green.jdevd010.CoffeeMintClient.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.jdevd010.CoffeeMintClient.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
