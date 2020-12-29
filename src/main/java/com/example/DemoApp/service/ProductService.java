package com.example.DemoApp.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DemoApp.entity.Product;
import com.example.DemoApp.repository.ProductRepository;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public void save(Product product) {

		productRepository.save(product);
	}

	public List<Product> listAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	public Product getById(Integer id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id).get();
	}
	
	public void delete(Integer id) {
		productRepository.deleteById(id);
	}

}
