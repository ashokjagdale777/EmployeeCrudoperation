package com.cg.SpringBootCrud.repository;

import org.springframework.data.repository.CrudRepository;

import com.cg.SpringBootCrud.bean.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, String> {
	
}
