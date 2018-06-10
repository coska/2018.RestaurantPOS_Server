package com.coska.lab.restaurantpos.api.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.coska.lab.restaurantpos.api.domain.ServTables;
import com.coska.lab.restaurantpos.api.model.Greeting;
import com.coska.lab.restaurantpos.api.repositories.TableRepository;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private TableRepository tableRepository;

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	// Get All Notes
	@GetMapping("/tables")
	public List<ServTables> getAllNotes() {
		return tableRepository.findAll();
	}

	@PostMapping("/tables")
	public ResponseEntity<Object> createStudent(@RequestBody ServTables student) {
		ServTables savedStudent = tableRepository.save(student);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedStudent.getTableId()).toUri();

		return ResponseEntity.created(location).build();

	}
	@PutMapping("/tables/{tableId}")
	public ResponseEntity<Object> updateStudent(@RequestBody ServTables student, @PathVariable long tableId) {

		Optional<ServTables> tableOptional = tableRepository.findById(tableId);

		if (!tableOptional.isPresent())
			return ResponseEntity.notFound().build();

		student.setTableId(tableId);
		
		tableRepository.save(student);

		return ResponseEntity.noContent().build();
	}
}