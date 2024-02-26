package com.java.intvw;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.concept.Employee;

public class EmployeeObjOperation {
	static List<Employee> elist = new ArrayList<Employee>();
	static {
		elist = Stream.of(new Employee("Raju", "Ele", 1),
				new Employee("Amit", "Mech", 12),
				new Employee("Hari", "Ele", 31),
				new Employee("Pankaj", "Cs", 14),
				new Employee("Karteek", "Mech", 5)).toList();
	}
	public static void main(String[] args) {
		sortWayEmpolyee();
		//get higest 2-4id employee
		getHighIdEmployee();
	}
	private static void sortWayEmpolyee() {
		List<Employee> sortEmpList = elist.stream()
				.sorted((o1,o2) -> o2.getId() - o1.getId())
				.collect(Collectors.toList());
		System.out.println("Sort -1 : \n"+sortEmpList);
		
		List<Employee> sortEmpList1 = elist.stream()
				.sorted(Comparator.comparingInt(Employee::getId).reversed())
				.collect(Collectors.toList());
		System.out.println("Sort ID -2 : \n"+ sortEmpList1);
		
		List<Employee> sortEmpList2 = elist.stream()
				.sorted((o1,o2) -> o2.getName().compareTo(o1.getName()))
				.collect(Collectors.toList());
		System.out.println("Sort Name -3 : \n"+ sortEmpList2);
		
	}
	private static void getHighIdEmployee() {
		List<Employee> sortEmpList = elist.stream()
				.sorted((o1,o2) -> o2.getId() - o1.getId())
				.skip(1)
				.limit(3)
				.collect(Collectors.toList());
		
		System.out.println(sortEmpList);
		
	}

}
