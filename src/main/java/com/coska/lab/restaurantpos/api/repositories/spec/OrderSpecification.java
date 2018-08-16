package com.coska.lab.restaurantpos.api.repositories.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.coska.lab.restaurantpos.api.domain.Order;
import com.coska.lab.restaurantpos.api.model.OrderTypes;

/**
 * Define detail conditions for getting data from Order table
 * @author sam
 */
public class OrderSpecification {
	@SuppressWarnings("serial")
	public static Specification<Order> statusNotServed() {
		return new Specification<Order>(){
			@Override
			public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				return criteriaBuilder.equal(root.<OrderTypes>get("status"), OrderTypes.SERVED).not();
			}
		};
	}
}