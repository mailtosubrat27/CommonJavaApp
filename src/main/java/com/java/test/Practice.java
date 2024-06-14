package com.java.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Practice {

	public static void main(String[] args) {
		String vil = "Badajhara Nuasahi";
		
		//get char frequency
		 Map<String, Long> collect = Arrays.stream(vil.split(""))
		.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		 System.out.println(collect.toString());
		 
		 Map<Character, Long> collect2 = vil.chars()
		 .mapToObj(a ->(char)a)
		 .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		 System.out.println(collect2.toString());

		 // find all duplicate elements- key and value
		 List<Entry<String, Long>> collect3 = Arrays.stream(vil.split(""))
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
			.entrySet()
			.stream()
			.filter(e -> e.getValue() >1)
			.collect(Collectors.toList());
		 System.out.println(collect3.toString());
		 
		 // find all duplicate keys
		 List<String> collect4 = Arrays.stream(vil.split(""))
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
			.entrySet()
			.stream()
			.filter(e -> e.getValue() >1)
			.map(e -> e.getKey())
			.collect(Collectors.toList());
		 System.out.println(collect4.toString());
		 
		 //find non repeat elements
		 List<String> collect5 = Arrays.stream(vil.split(""))
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
			.entrySet()
			.stream()
			.filter(e -> e.getValue() ==1)
			.map(e -> e.getKey())
			.collect(Collectors.toList());
		 System.out.println(collect5.toString());
		 
		 
		 int[] numbs = {32,12,5,3,8,43, 12, 18};
		 
		 //sort descending order
		 List<Integer> collect8 = Arrays.stream(numbs).boxed()
		 .sorted(Comparator.reverseOrder())
		 .collect(Collectors.toList());
		 System.out.println(collect8);
		 
		 List<Integer> collect9 = Arrays.stream(numbs).boxed()
		 .sorted((a,b) -> (a < b) ? 1 : (a > b)? -1 : 0)
		 .collect(Collectors.toList());
		 System.out.println(collect9);
		 
		 // sort ascending order
		 List<Integer> collect10 = Arrays.stream(numbs).boxed()
		 .sorted(Integer::compareTo)
		 .collect(Collectors.toList());
		 System.out.println("--11-: "+collect10);

		 //find 2nd Highest no
		   Optional<Integer> min = Arrays.stream(numbs).boxed()
		 .sorted(Comparator.reverseOrder())
		 .limit(2)
		 .min(Integer:: compareTo);
		 System.out.println(min.get());
		 
		 // find duplicate
		 Set<Integer> s = new HashSet<Integer>();
		 List<Integer> collect6 = Arrays.stream(numbs).boxed()
		 .filter(a -> !s.add(a))
		 .collect(Collectors.toList());
		 System.out.println(collect6);

		 //Find sum
		 Optional<Integer> reduce = Arrays.stream(numbs).boxed()
		 .reduce((x,y) -> x+y);
		 System.out.println(reduce.get());
		 
		 // find elements starts with 1
		 List<Integer> collect7 = Arrays.stream(numbs).boxed()
		 .map(a -> a+"")
		 .filter(ls -> ls.startsWith("1"))
		 .map(b -> Integer.parseInt(b))
		 .collect(Collectors.toList());
		 System.out.println(collect7);
		 
		 String[] strArr = {"Hello", "Raju", "G", "thisislong"};
		 
		 //longest string
		 Optional<String> reduce2 = Arrays.stream(strArr)
		 .reduce((x,y) -> x.length() > y.length() ? x : y);
		 System.out.println("LOngest String - "+reduce2.get());
		 
		 //Join strings to a single string
		 Optional<String> reduce3 = Arrays.stream(strArr)
		 .reduce((x,y) -> x+"++"+y);
		 System.out.println(reduce3.get());
		 
		 String join = String.join("--", strArr);
		 System.out.println(join);
		 
		 //Sort strings based on string length
		 List<String> list = Arrays.stream(strArr)
//		 .sorted(Comparator.comparingInt(String::length))
		 .sorted((a,b) -> -(Integer.compare(a.length(), b.length())))
		 .toList();
		 System.out.println(list);
		 
		 //Sort strings based on string length ascending
		 Arrays.stream(strArr)
	        .collect(Collectors.toMap(s1 -> s1, String::length))
	        .entrySet()
	        .stream()
	        .sorted(Map.Entry.comparingByValue())
	        .map(Map.Entry::getKey)
	        .forEach(System.out::println);
	 
		List<Integer> l1 = Arrays.asList(11, 13, 14, 18, 15);
		List<Integer> l2 = Arrays.asList(11, 22, 12, 13, 15);

		// Add two list
		List<Integer> newList1 = Stream.concat(l1.stream(), l2.stream()).toList();
		System.out.println("2- Add two Lists using concat : " + newList1);

		// Range -- for loop
		IntStream.range(1, 10).boxed().forEach(System.out::print);
		
		int ab[] = {1,2,3,4,1,4};
		
		//find first single repeat character
		int key = Arrays.stream(ab).boxed()
		.collect(Collectors.groupingBy(Function.identity(), TreeMap :: new, Collectors.counting()))
		.entrySet()
		.stream()
		.filter(a -> a.getValue() ==1)
		.toList().get(0)
		.getKey();
		
		System.out.println("\nFirst repeat: "+key);
		
		
		//print words in reverse order
		 List<String> numberWords = Arrays.asList("one", "two", "three", "four", "five");
		 IntStream.range(0, numberWords.size())
		 .mapToObj(i -> numberWords.get(numberWords.size()-1-i))
		 .forEach(System.out :: print);

		
		//Integer and int in pojo object
		
	}

}
