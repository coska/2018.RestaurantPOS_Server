package com.coska.lab.restaurantpos.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coska.lab.restaurantpos.api.domain.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
	Employee findByUserName(String userName);
	Employee findByUserId(String userId);
}
