package com.concept;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.text.html.parser.Entity;

public class EmployeeDeptList {

	public static void main(String[] args) {
		List<Employee> elist = Stream.of(new Employee("Raju", "Ele", 1),
				new Employee("Amit", "Mech", 2),
				new Employee("Hari", "Ele", 3),
				new Employee("Pankaj", "Cs", 4),
				new Employee("Karteek", "Tech", 5)).toList();
		
		List<Employee> elist2 = Stream.of(new Employee("Ramesh", "Sing", "Math", 12000L, 25, "M", 1),
				new Employee("Shruti", "Sing", "Che", 11000L, 32, "F", 2),
				new Employee("Anshu", "Sahu", "Math", 12500L, 30, "M", 3),
				new Employee("Haru", "Sing", "CS", 10000L, 29, "M", 4),
				new Employee("Sulu", "hal", "Phy", 18000L, 42, "F", 5)).toList();
		
		List<String> deptList = elist.stream().map(Employee :: getDept).collect(Collectors.toList());
		System.out.println("Department List: "+ deptList);
		
		//no of employee in same dept
		Map<String, Long> empsinDept =
				elist.stream().collect(Collectors.groupingBy(
						Employee:: getDept, TreeMap::new, Collectors.counting()));
		
		System.out.println("Employees in same Dept: "+empsinDept);
		
		//sort employees based on emp name and  dept name
		List<Employee> collect = elist.stream()
		.sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getDept))
		.collect(Collectors.toList());
		
		System.out.println("Sort employees based on emp name and  dept name: "+collect);
		
		//sort employees based on emp name and  dept name descending order
		List<Employee> collect1 = elist.stream()
				.sorted(Comparator.comparing(Employee::getName, Comparator.reverseOrder())
						.thenComparing(Employee::getDept, Comparator.reverseOrder()))
				.collect(Collectors.toList());
				
		System.out.println("Sort employees based on emp name and  dept name descending order: "+collect1);
		
		//find the emp age btwn 30-40
		List<Employee> collect2 = elist2.stream()
		.filter(a -> a.getAge() >30 && a.getAge() < 40)
		.collect(Collectors.toList());
		System.out.println(collect2);
		
		// find the employee whose surname is Sing and sort by names
		List<Employee> collect3 = elist2.stream()
		.filter(a -> a.getLastName().equals("Sing"))
		.sorted(Comparator.comparing(Employee::getName))
		.collect(Collectors.toList());	
		System.out.println(collect3);
		
		// Find employee group by gender
		Map<String, List<Employee>> collect4 = elist2.stream()
		.collect(Collectors.groupingBy(Employee :: getGender));
		System.out.println(collect4);
		
		// Find no emp in each gender
		Map<String, Long> collect5 = elist2.stream()
		.collect(Collectors.groupingBy(Employee :: getGender, Collectors.counting()));
		System.out.println(collect5);
		
		// find emp in which gender has max no
		Optional<Entry<String, Long>> reduce = elist2.stream()
		.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()))
		.entrySet()
		.stream()
		.reduce((a,b) -> a.getValue() > b.getValue()? a : b);
		System.out.println(reduce.get());
		
		Optional<Entry<String, Long>> max = elist2.stream()
		.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()))
		.entrySet()
		.stream()
		.max(Map.Entry.comparingByValue());
		System.out.println(max.get());
		
		//Find averge age of Male and female employee
		Map<String, Double> collect6 = elist2.stream()
		.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
		System.out.println(collect6);
		
		
		
		
		
		
		//find only name and gender form employee whose age >30
		
		
	}

	
}
