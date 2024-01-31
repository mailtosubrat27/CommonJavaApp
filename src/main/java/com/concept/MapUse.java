/**
 * 
 */
package com.concept;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
/**
 * 
 */
public class MapUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> noList = Arrays.asList(5,2,6,4,76,34,27,5,87,7);
		//find even no and 10 in same list
		
		List<Integer> even10 =noList.stream().filter(x -> x%2 == 0).map(x -> x+10).collect(toList());
		System.out.println("even10 :"+ even10);
		
		// add 10 to each prime no
		List<Integer> primeNos = noList.stream()
        .filter(MapUse::isPrime)
        .collect(toList());

		System.out.println("primeNos :"+ primeNos);
		
				
		// Separate even and odd no 
		List<Integer> evenOdd =noList.stream().map(x -> {
			if(x%2 ==0) {
				return x+10;
			}
			return x;
		}).collect(toList());
		System.out.println("evenOdd :"+ evenOdd);
		
	}
	
	public static boolean isPrime(int number) {
	    return !IntStream.rangeClosed(2, number/2).anyMatch(i -> number%i == 0); 
	}

}
