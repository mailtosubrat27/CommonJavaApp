package com.java.intvw;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BasicJava8Operation {
	
	//1- Order List - asc and desc
	//2- Reduce
	//3- Combine two List
	// 4- find duplicate  and unique elements from List
	// 5- Add sum of list
	// 6- for loop using stream
	
	// esleif - Optional
	
	// All functional interface use as function argument m(supplier ..)
	// Iterate Map
	//Char Frequency

	public static void main(String[] args) {

		List<Integer> l1 = Arrays.asList(12,14,11,12,43,23,43,23);
		List<Integer> l2 = Arrays.asList(10, 20, 30);
		
		//1- Order List - asc and desc
		orderList(l1);
		
		//2- Reduce
		reduceFunc(l1);
		
		//3- Combine two List
		mergeList(l1,l2);
		
		// 4- find duplicate  and unique elements from List
		duplicateAndUniqueEle(l1);
		
		// 6- for loop using stream
		forLoopStream(l1);
		
		// Iterate Map
		iterateMap();
	}

	private static void forLoopStream(List<Integer> l1) {
		IntStream.range(0, l1.size())
		.forEach(a -> System.out.println("Loop : "+ l1.get(a)));
		
	}

	private static void reduceFunc(List<Integer> l1) {

		Integer sumValue = l1.stream()
		.reduce((a,b) -> a+b)
		.get();
		
		System.out.println("2.1 - SUM - Reduce : "+ sumValue);
		
	}

	private static void iterateMap() {
		Map<Integer, Integer> mp = Map.of(10, 1, 11, 2, 12, 3);
		mp.entrySet()
		.forEach(e -> System.out.print(e.getKey() +" :: " + e.getValue() +", "));
//		System.out.println(mp);
		
	}

	private static void mergeList(List<Integer> l1, List<Integer> l2) {
		List<Integer> newList = Stream.of(l1, l2)
				.flatMap(Collection :: parallelStream)
				.collect(Collectors.toList());
		
		System.out.println("3.1- Add two Lists using flatmap : "+ newList);
				
		List<Integer> newList1 = Stream.concat(l1.stream(), l2.stream())
				.toList();
		System.out.println("3.2- Add two Lists using concat : "+ newList1);
		
		
	}

	private static void orderList(List<Integer> l1) {
		List<Integer> orderList = l1.stream()
		.sorted()
		.collect(Collectors.toList());
		
		System.out.println("1- Order asc: " +orderList);
		
		List<Integer> reverseOrder = l1.stream()
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		System.out.println("2- Order Desc: " +reverseOrder);
	}

	private static void duplicateAndUniqueEle(List<Integer> l1) {
		List<Integer>listUnique = l1.stream()
				.distinct()
				.collect(Collectors.toList());
		System.out.println("Unique elements : " +listUnique);
		
		// inner loop to find duplicate
		Set<Integer> duplicateEle = l1.stream()
				.filter(n -> l1.stream()
						.filter(x -> x == n)
						.count() > 1)
				.collect(Collectors.toSet());
		System.out.println("4.1 - Duplicate elements : "+ duplicateEle);
		
		
		System.out.println("Count total no: "+ l1.stream().count());
		
		//non repeat elements
		Set<Integer> nonRepeatEle = l1.stream()
				.filter(n -> l1.stream()
						.filter(x -> x == n)
						.count() == 1)
				.collect(Collectors.toSet());
		System.out.println("Non repeat elements : "+ nonRepeatEle);
		
	}

}
