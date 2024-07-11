package com.java.intvw;

import java.util.HashMap;
import java.util.Map;

public class NetcrackerTest2 {

	public static void main(String[] args) {
		//task
		stringValue();
		equalInteger();
		
		System.out.println(intReturn());
		
		concatChar();
		
		stringEquals();
		
		addPersonMap();
		

	}

	private static void addPersonMap() {
		Map<Person, Boolean> map = new HashMap<Person, Boolean>();
		Person p1 = new Person("John", 10);
		map.put(p1, false);
		Person p2 = new Person("John", 10);
		map.put(p2, true);
		System.out.println("Map :"+map.get(p1));
		
	}

	private static void stringEquals() {
		String s1 = "John";
		String s2 = new String(s1);
		
		System.out.println((s1==s2) +" "+ (s1.equals(s2)));
		
	}

	private static void concatChar() {
		 // the line below this gives an output 
        // \u000d System.out.println("comment executed"); 
		System.out.println('J'+'a'+'v'+'a');
	}

	private static int intReturn() {
		
//		return (True) ? null : 0;
		
//		return null;
		
		return 0;
	}

	private static void equalInteger() {
		Integer i1 = 127;
		Integer i2 = 127;
		System.out.println(i1 == i2);
		
		Integer i3 = 128;
		Integer i4 = 128;
		
		System.out.println(i3==i4);
		
		
	}

	private static void stringValue() {
		String s = "One"+1+2+"Two"+3+4+"Three"+0+5+"Four";
		System.out.println(s);

		
	}

}

class Person {
	public Person (String name, int age ) {
		super();
		this.name = name;
		this.age = age;
	}
	String name;
	int age;
}
