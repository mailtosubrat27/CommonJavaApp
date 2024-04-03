package com.concept;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayElementOpTest {

	public static void main(String[] args) {
		List<Integer> noList = Arrays.asList(10,101,192,13,15,16,7,2,243,25,4);
		List<Integer> limit = noList.stream().limit(2).collect(Collectors.toList());
		System.out.println(limit);
		
		List<Integer> skip = noList.stream().skip(2).collect(Collectors.toList());
		System.out.println(skip);
		
		//Get SUM of the list
		int p=noList.stream().reduce(10, (x,y)->x+y);
		System.out.println(p);
		
		//Sort elements- ascending 
		 List<Integer> sorted = noList.stream()
			.sorted(Integer :: compare)
			.collect(Collectors.toList());
		 System.out.println("Ascending Sorted: "+ sorted);
		 
		//Sort elements- descending
		 
	}

}
