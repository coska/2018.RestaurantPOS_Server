package com.coska.lab.restaurantpos.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coska.lab.restaurantpos.api.domain.Product;
import com.coska.lab.restaurantpos.api.repositories.ProductRepository;

@RestController
public class ProductController {


	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/products")
//	public List<Product> getAllProducts(@RequestParam(name = "categoryId") Long categoryId){
	public List<Product> getAllProducts(){
		return productRepository.findAll();
//		return productRepository.findByCategoryId(categoryId);
	}
	
	@GetMapping("/products/{productId}")
	public Product getProductById(@PathVariable String productId) {
		return productRepository.findByProductId(productId);
	}
	
	
	@PostMapping("/products")
	public Product createProduct(@Valid @RequestBody Product product) {
		return productRepository.save(product);
	}
}
