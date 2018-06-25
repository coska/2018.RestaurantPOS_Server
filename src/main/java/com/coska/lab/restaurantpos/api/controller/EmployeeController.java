package com.coska.lab.restaurantpos.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.coska.lab.restaurantpos.api.domain.Employee;
import com.coska.lab.restaurantpos.api.repositories.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@GetMapping("/employee")
	public List<Employee> getAllEmployee(){
		return employeeRepository.findAll();
	}
	
	
	@GetMapping("/employee/{userId}")
	public Employee getEmpoloyeeByName(@PathVariable String userId) {
		return employeeRepository.findByUserId(userId);
	}
}
