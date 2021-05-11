package com.coska.lab.restaurantpos.api.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coska.lab.restaurantpos.api.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>{
	Product findByProductId(String productId); 
//	List<Product> findByCategoryId(Long categoryId); 
}
