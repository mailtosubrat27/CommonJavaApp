package com.concept;

public class Employee {
	String name;
	String dept;
	Integer id;
	
	public Employee(String name, String dept, Integer id) {
		super();
		this.name = name;
		this.dept = dept;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public String getDept() {
		return dept;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", dept=" + dept + ", id=" + id + "]";
	}
	
	
}
