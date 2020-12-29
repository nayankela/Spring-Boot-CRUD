package com.example.DemoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DemoApp.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
