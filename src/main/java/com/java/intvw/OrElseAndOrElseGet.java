package com.java.intvw;

import java.util.stream.Stream;
/*
 orElse and orElseGet both are Optional class methods
 - if value is not present both orElse and orElseget will be invoked and assign the return value
 - if value is present orElese will be invoked but return value will not assign
 - if value is present orEleseGet method will not be invoked 
 
 */
public class OrElseAndOrElseGet {

	public static void main(String[] args) {
		String orElse = Stream.of("This","is", "orElse", "orElseGet")
		.filter(s -> s.startsWith("o"))
		.findFirst()
		.orElse(show("A"));
		
		System.out.println(orElse);
		System.out.println("--------------");
		
		String orElseGet = Stream.of("This","is", "orElse-", "orElseGet")
				.filter(s -> s.startsWith("o"))
				.findFirst()
				.orElseGet(() ->show("B"));
		System.out.println(orElseGet);
		
		System.out.println("\n#########\n");
		
		String orElse1 = Stream.of("This","is", "orElse", "orElseGet")
				.filter(s -> s.startsWith("M"))
				.findFirst()
				.orElse(show("C"));
				
				System.out.println(orElse1);
				System.out.println("--------------");
				
				String orElseGet1 = Stream.of("This","is", "orElse", "orElseGet")
						.filter(s -> s.startsWith("M"))
						.findFirst()
						.orElseGet(() ->show("D"));
				System.out.println(orElseGet1);
	}

	private static String show(String s) {
		System.out.println("-- Inside show --: "+s);
		return "Hello";
	}

}
