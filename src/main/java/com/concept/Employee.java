package com.concept;

public class Employee {
	String name;
	String lastName;
	String dept;
	Long salary;
	Integer age;
	String gender;
	Integer id;
	
	public Employee(String name, String dept, Integer id) {
		super();
		this.name = name;
		this.dept = dept;
		this.id = id;
	}
	
	
	public Employee(String name, String lastName, String dept, Long salary, Integer age, String gender, Integer id) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.dept = dept;
		this.salary = salary;
		this.age = age;
		this.gender = gender;
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", lastName=" + lastName + ", dept=" + dept + ", salary=" + salary + ", age="
				+ age + ", gender=" + gender + ", id=" + id + "]";
	}
	
	
	
}
