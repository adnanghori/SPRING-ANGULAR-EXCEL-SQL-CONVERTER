package com.springboot.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.api.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
