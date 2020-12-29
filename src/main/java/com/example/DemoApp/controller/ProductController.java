package com.example.DemoApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DemoApp.entity.Product;
import com.example.DemoApp.service.ProductService;

@RestController
@RequestMapping("/app")
public class ProductController {

	@Autowired
	private ProductService service;

	@PostMapping("/save")
	public void save(@RequestBody Product product) {

		service.save(product);
	}

	@GetMapping("/getAll")
	public List<Product> listAll() {
		return service.listAllProducts();
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<Product> get(@PathVariable Integer id) {
		Product product = service.getById(id);

		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@PutMapping("/products/{id}")
	public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Integer id) {
		@SuppressWarnings("unused")
		Product existing = service.getById(id);
		service.save(product);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@DeleteMapping("/products/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}

}
