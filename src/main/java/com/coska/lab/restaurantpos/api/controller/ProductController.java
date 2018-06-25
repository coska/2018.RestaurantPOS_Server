package com.coska.lab.restaurantpos.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coska.lab.restaurantpos.api.domain.Product;
import com.coska.lab.restaurantpos.api.repositories.ProductRepository;

@RestController
public class ProductController {


	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}

}
