package com.coska.lab.restaurantpos.api.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coska.lab.restaurantpos.api.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	Category findByCategoryName(String userName);
	Category findByCategoryId(Long id);
}
