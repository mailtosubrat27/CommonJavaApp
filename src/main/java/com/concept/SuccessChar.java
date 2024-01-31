package com.concept;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SuccessChar {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the word : ");
		String str = scanner.nextLine();
		
		// Char count from a word SUCCESS
//		String str = "SUCCESS";
		 Map<Character,Long> hm = str.chars().mapToObj(c-> 
		    (char)c).collect(Collectors.groupingBy(c->c,Collectors.counting()));
		    System.out.println(hm);


		    str.chars()
		    .mapToObj(c-> (char)c)
		    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
			.forEach((key, value) -> System.out.println(key + " : " + value));
     
			
	}

}
