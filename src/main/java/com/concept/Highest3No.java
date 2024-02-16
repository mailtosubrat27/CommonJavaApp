package com.concept;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BooleanSupplier;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Highest3No {

	public static void main(String[] args) {

		Integer integer = Stream.of(10, 12, 54, 2, 554, 32, 21).sorted().max(Integer::compare).get();

		System.out.println("Max : " + integer);

		// Distinct elements
		List<Integer> list = Stream.of(10, 12, 54, 2, 554, 32, 2, 12).distinct().toList();
		System.out.println("Distinct : " + list);

		// repeated elements
		List<Integer> numbers = Arrays.asList(10, 12, 54, 2, 554, 32, 2, 12);
		Set set = (Set) numbers.stream()
				.filter(i -> Collections.frequency(numbers, i) > 1)
				.collect(Collectors.toSet());
		System.out.println("1.Repreated : " + set);

		// 2
		List<Integer> duplicateNo = numbers.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet()
				.stream()
				.filter(p -> p.getValue() > 1)
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());

		System.out.println("2.Repreated : " + duplicateNo);

		// create a sequence no from two list
		// merge two list
		List<Integer> l1 = Arrays.asList(10, 12, 54, 2, 554, 32);
		List<Integer> l2 = Arrays.asList(8, 11, 87, 12,60, 29, 3, 9);
		List<Integer> mergeList = Stream.of(l1, l2)
				.flatMap(Collection::stream)
				.sorted()
				.collect(Collectors.toList());
		System.out.println("Merge List : " + mergeList);

		// 3rd Highest no - 1
		Integer thirdHighest = mergeList.stream()
				.sorted(Comparator.reverseOrder())
				.skip(2)
				.findFirst()
				.orElse(null);

		System.out.println("Top Third no : " + thirdHighest);
		
		// 3rd Highest no - 2
		Optional<Integer> find3rd = mergeList.stream()
			.distinct()
			.sorted((a,b) -> b-a)
			.skip(2)
			.findFirst();
		System.out.println("Top Third no - 2 : " + find3rd.get());
	}

}
