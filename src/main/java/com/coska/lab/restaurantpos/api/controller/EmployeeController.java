package com.coska.lab.restaurantpos.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/employee")
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		String id = employee.getUserId();
		Employee em = null;
		em = employeeRepository.findByUserId(id);
		
		// will create custom exception
		if(em != null)
			throw new RuntimeException("employee id is already exist");
	    return employeeRepository.save(employee);
	}
	
	@PutMapping("/employee/{userId}/token/{token}")
	public Employee updateEmpoloyeeToken(@PathVariable String userId, @PathVariable String token) {
		Employee em =  employeeRepository.findByUserId(userId);
		if(em != null) {
			em.setExpoPushToken(token);
			employeeRepository.save(em);
		}
		
		return employeeRepository.findByUserId(userId);
	}
}
