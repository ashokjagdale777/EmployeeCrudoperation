package com.cg.SpringBootCrud.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.cg.SpringBootCrud.bean.Employee;
import com.cg.SpringBootCrud.repository.EmployeeRepo;

@Service

public class EmployeeService {

	@Autowired

	private EmployeeRepo empRepo;

	public Map<String, Employee> getAllEmployees() {

		Map<String, Employee> employees = new HashMap<>();

		empRepo.findAll().forEach(employee -> employees.put(employee.getId(), employee));

		return employees;

	}

	public boolean addEmployee(Employee employee) {

		try {

			empRepo.save(employee);

			return true;

		} catch (Exception e) {

			return false;

		}

	}

	public boolean UpdateEmployee(String id, Employee employee) {

		try {

			Employee existingEmployee = empRepo.findById(id).orElse(null);

			if (existingEmployee != null) {

				existingEmployee.setName(employee.getName());

				existingEmployee.setId(employee.getId());

				// Update other properties as needed

				empRepo.save(existingEmployee);

				return true;

			} else {

				return false; // Employee not found

			}

		} catch (Exception e) {

			return false; // Error occurred

		}

	}

	public boolean deleteEmployee(String id) {

		try {

			empRepo.deleteById(id);

			return true;

		} catch (Exception e) {

			return false;

		}

	}

}