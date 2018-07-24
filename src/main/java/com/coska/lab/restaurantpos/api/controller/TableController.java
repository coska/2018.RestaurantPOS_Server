package com.coska.lab.restaurantpos.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coska.lab.restaurantpos.api.domain.ServTables;
import com.coska.lab.restaurantpos.api.exception.ResourceNotFoundException;
import com.coska.lab.restaurantpos.api.repositories.TableRepository;

@RestController
public class TableController {


	@Autowired
	private TableRepository tableRepository;
	
	
	@GetMapping("/tables")
	public List<ServTables> getAllTables() {
		return tableRepository.findAll();
	}
	
	@GetMapping("/tables/{tableName}")
	public ServTables getTableByName(@PathVariable String tableName) {
		ServTables servTable = null;
		servTable =	tableRepository.findByName(tableName);
		if(servTable == null){
			throw new ResourceNotFoundException("Table", "Table Name", tableName);
		}
		return servTable;
	}
	
	
	@PostMapping("/tables")
	public ServTables createTable(@Valid @RequestBody ServTables table) {
		ServTables savedtable = tableRepository.save(table);

		/*URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedtable.getTableId()).toUri();

		return ResponseEntity.created(location).build();*/
		return savedtable;

	}
	@PutMapping("/tables/{tableId}")
	public ResponseEntity<Object> updateTable(@RequestBody ServTables table, @PathVariable long tableId) {

		Optional<ServTables> tableOptional = tableRepository.findById(tableId);

		if (!tableOptional.isPresent())
			return ResponseEntity.notFound().build();

		table.setTableId(tableId);
		
		tableRepository.save(table);

		return ResponseEntity.noContent().build();
	}
}
