package com.coska.lab.restaurantpos.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coska.lab.restaurantpos.api.domain.Category;
import com.coska.lab.restaurantpos.api.repositories.CategoryRepository;

@RestController
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping("/categories")
	public List<Category> getAllCategory(){
		return categoryRepository.findAll();
	}

	@GetMapping("/categories/{categoryId}")
	public Category getCategory(@PathVariable Long categoryId){
		return categoryRepository.findByCategoryId(categoryId);
	}
	
	@PostMapping("/categories")
	public Category createCategory(@Valid @RequestBody Category category) {
		Long id = category.getCategoryId();
		Category cat = null;
		cat = categoryRepository.findByCategoryId(id);
		//
		if(cat != null)
			throw new RuntimeException("Category id is already exist");
		return categoryRepository.save(category);
	}

}
