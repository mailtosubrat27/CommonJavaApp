package com.concept;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GroupBy {

	public static void main(String[] args) {
		
		//Find the occurance 
		 List<String> data = Arrays.asList("apple", "banana", "apple", "cherry", "banana", "apple");

         Map<String, Long> groupedData = data.stream()
                 .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

         String response = groupedData.toString();
         
         System.out.println(" Resp:"+ response);
         
         String inputString = "Java Concept Of The Day";
         Map<Character, Long> charCountMap = inputString.chars().mapToObj(a -> (char)a)
         .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
         
         System.out.println(" Letter count : "+ charCountMap);
         
         intRange();
	}
	
	public static void intRange() {
		Map<Integer, Integer> MAP = IntStream.rangeClosed(1, 2)
				.boxed()
				.collect(Collectors.toMap(Function.identity(), v -> v*10));
		System.out.println("---- MAP ----" );
		System.out.println(MAP);
	}

}
