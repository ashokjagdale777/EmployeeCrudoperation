package com.cg.SpringBootCrud.bean;

import jakarta.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	private String id;
	private String name;

	public Employee() {
		super();
	}

	public Employee(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
