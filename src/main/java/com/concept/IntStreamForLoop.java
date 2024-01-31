package com.concept;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamForLoop {

	public static void main(String[] args) {
		IntStream range = IntStream.range(1, 20);
		List<Integer> list = range.boxed().collect(Collectors.toList());
		
		System.out.println(list);
		
	}

}
