package com.concept;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ProgrammingJ8 {

	public static void main(String[] args) {
		// list the nos starts from 1
		List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 32, 15, 25);
		myList.stream().allMatch(s -> s.toString().startsWith("1"));
		System.out.println(myList);

		// find greater no using reduce method
		Optional<Integer> no = myList.stream().reduce((a, b) -> a > b ? a : b);
		System.out.println("Greater no: " + no);

		// find sum of even nos using reduce method
		Integer sumOfEven = myList.stream().reduce(0,(a, b) -> {

			// Check if the number is even
			if(b % 2 == 0)
				a += b;
			return a;
		});
		System.out.println("Sum of even nos: " + sumOfEven);
		
		// Find sum using reduce method
		Integer sumOfno = myList.stream().reduce(0,(a, b) -> a+b);

		System.out.println("Sum of nos- 1-: " + sumOfno);
		
		// Find max no 
		Integer max = myList.stream().max(Integer :: compare).get();
		Integer max1 = myList.stream().reduce(10, (a,b) -> a>b? a: b);
		System.out.println("Max no 1-: " + max +" 2-: "+max1);
		
		// Find min no 
		Integer min = myList.stream().min(Integer :: compare).get();
		Integer min1 = myList.stream().reduce(10, (a,b) -> a>b? b:a);
		System.out.println("Max no 1-: " + min +" 2-: "+min1);
		
		//Find duplicate no from list
//		myList.stream().
		Set<Integer> allItems = new HashSet<>();
		Set<Integer> duplicates = myList.stream()
		        .filter(n -> !allItems.add(n)) //Set.add() returns false if the item was already in the set.
		        .collect(Collectors.toSet());
		System.out.println("Duplicate elements :"+ duplicates);
	}

}
