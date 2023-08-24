package com.cg.SpringBootCrud.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cg.SpringBootCrud.bean.Employee;
import com.cg.SpringBootCrud.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@GetMapping("/employees")
	public Map<String, Employee> getAllEmployees() {
		return empService.getAllEmployees();
	}

	@PostMapping("/addemployees")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
		boolean isAdded = empService.addEmployee(employee);
		if (isAdded) {
			return ResponseEntity.ok("True");
		} else {
			return ResponseEntity.badRequest().body("False");
		}
	}

	@PutMapping("/updateemployees/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable String id, @RequestBody Employee employee) {
		boolean isUpdated = empService.UpdateEmployee(id, employee);
		if (isUpdated) {
			return ResponseEntity.ok("True");
		} else {
			return ResponseEntity.badRequest().body("False");
		}
	}

	@DeleteMapping("/deleteemployees/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable String id) {
		boolean isDeleted = empService.deleteEmployee(id);
		if (isDeleted) {
			return ResponseEntity.ok("True");
		} else {
			return ResponseEntity.badRequest().body("False");
		}
	}
}