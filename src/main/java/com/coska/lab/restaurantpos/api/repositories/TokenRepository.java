package com.coska.lab.restaurantpos.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coska.lab.restaurantpos.api.domain.UserToken;

@Repository
public interface TokenRepository extends JpaRepository<UserToken, String> {
	UserToken findByUserId(String userId);

}
