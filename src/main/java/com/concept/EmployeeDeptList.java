package com.concept;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeDeptList {

	public static void main(String[] args) {
		List<Employee> elist = Stream.of(new Employee("Raju", "Ele", 1),
				new Employee("Amit", "Mech", 2),
				new Employee("Hari", "Ele", 3),
				new Employee("Pankaj", "Cs", 4),
				new Employee("Karteek", "Mech", 5)).toList();
		
		List<String> deptList = elist.stream().map(Employee :: getDept).collect(Collectors.toList());
		System.out.println("Department List: "+ deptList);
		
		//no of employee in same list
		Map<String, Long> empsinDept =
				elist.stream().collect(Collectors.groupingBy(
						Employee:: getDept, TreeMap::new, Collectors.counting()));
		
		System.out.println("Employees in same Dept: "+empsinDept);
		
		elist.stream().collect(Collectors.groupingBy(
				Employee:: getDept, TreeMap::new, Collectors.counting()));
	}

}
