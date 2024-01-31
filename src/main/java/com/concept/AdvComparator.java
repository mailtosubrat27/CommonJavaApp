package com.concept;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AdvComparator {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("John", "Jane", "Jim", "Jack");
		names.sort(Comparator.naturalOrder()); 
		System.out.println("Natural Order :"+ names);
		names.sort(Comparator.reverseOrder());
		System.out.println("Reverse Order :"+ names);
		
		List<String> names2 = Arrays.asList("John", null, "Jane", "Jim", null, "Jack");
		names2.sort(Comparator.nullsFirst(Comparator.naturalOrder())); // Places nulls first
		System.out.println("Null First Order :"+ names2);

		List<Person> people = Arrays.asList(new Person("John", 30), new Person("Jane", 25), new Person("Jim", 35));
		people.sort(Comparator.comparing(Person::getAge)); // Sorts by age
		System.out.println("Sort person- Age :" + people);

		List<Person> people2 = Arrays.asList(new Person("John", 30), new Person("Jane", 25), new Person("Jim", 30));
		people2.sort(Comparator.comparing(Person::getAge).thenComparing(Person::getName)); // Sorts by age, then by name
		System.out.println("Sort person- Age, name :" + people2);
		
	}
	


}

class Person {
	String name;
	Integer age;
	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public Integer getAge() {
		return age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}
