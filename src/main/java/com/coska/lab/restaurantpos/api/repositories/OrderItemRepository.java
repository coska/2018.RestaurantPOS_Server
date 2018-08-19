package com.coska.lab.restaurantpos.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coska.lab.restaurantpos.api.domain.OrderItem;
import com.coska.lab.restaurantpos.api.domain.OrderItemId;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemId> {

}
