package com.java.intvw;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddTwoListAndFindDuplicate {

	public static void main(String[] args) {
		List<Integer> l1 = Arrays.asList(11,13,14,18,15);
		List<Integer> l2 = Arrays.asList(11,22,12,13,15);
		
		findDuplicateFromList(l1, l2);
		
		//add two list
		addTwoList(l1, l2);

	}

	private static void addTwoList(List<Integer> l1, List<Integer> l2) {
		List<Integer> newList = Stream.of(l1, l2)
				.flatMap(Collection :: parallelStream)
				.collect(Collectors.toList());
		
		System.out.println("1- Add two Lists using flatmap : "+ newList);
				
		List<Integer> newList1 = Stream.concat(l1.stream(), l2.stream())
				.toList();
		System.out.println("2- Add two Lists using concat : "+ newList1);
		
//		Stream.generate(new Random() :: nextInt)
//		.limit(5)
//		.forEach(System.out :: println);
	}

	private static void findDuplicateFromList(List<Integer> l1, List<Integer> l2) {
		List<Integer> newList = Stream.of(l1, l2)
				.flatMap(Collection :: parallelStream)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet()
				.stream()
				.filter(p -> p.getValue()>1)
				.map( Map.Entry::getKey )
				   .collect( Collectors.toList() );
		
		System.out.println("1- Duplicate List : "+ newList);
		
		List<Integer> collect = l1.stream().filter(l2::contains)
		        .collect(Collectors.toList());
		System.out.println("2- Duplicate List : "+ collect);
		
	}

}
