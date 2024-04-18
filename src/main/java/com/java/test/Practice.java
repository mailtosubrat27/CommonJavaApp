package com.java.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
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
		 System.out.println(reduce2.get());
		 
		 //Join strings to a single string
		 Optional<String> reduce3 = Arrays.stream(strArr)
		 .reduce((x,y) -> x+"++"+y);
		 System.out.println(reduce3.get());
		 String join = String.join("--", strArr);
		 System.out.println(join);

	}

}
