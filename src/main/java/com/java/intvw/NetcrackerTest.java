package com.java.intvw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NetcrackerTest {

	public static void main(String[] args) {
		totalProductCost();
		
		filterOddNumberAndSort();
	}

	private static void filterOddNumberAndSort() {
		 List<Integer> numbers = Arrays.asList(1,34,22,13,55,4,3,87,11,22,12);
	        System.out.println("Unsorted Unfiltered List = " + numbers);
	        List<Integer> filteredAndSortedNumbers = filterAndSort(numbers);
	        System.out.println("Sorted Filtered List = " + filteredAndSortedNumbers);
	}

	private static List<Integer> filterAndSort(List<Integer> numbers) {
		 return numbers.stream()
			      .filter(a -> a%2 !=0 )
			      .sorted()
			      .collect(Collectors.toList());
			    
	}

	private static void totalProductCost() {
		List<Product> product = new ArrayList<>();
        product.add(new Product("radio", 99.0, 0));
        product.add(new Product("television", 82.0, 3));
        product.add(new Product("earbud", 82.5, 5));
        product.add(new Product("charger", 88.5, 0));
        product.add(new Product("mobile", 99.5, 2));
        
        // television 242
        // earbud 412.5
        // solution -1
        product.stream()
        .filter(a -> a.getQuantity() > 0)
        .forEach(a -> {
        	System.out.println(a.getName() + " " +( a.getPrice() * a.getQuantity()));
        });
        
        //solution 2
        product.stream()
        .filter(a -> a.getQuantity() > 0)
        .map(a -> a.getName() + " " +  a.getPrice() * a.getQuantity())
        .forEach(System.out::println);
        
        
//        Product totalCost = product.stream()
//                .reduce((x,y) -> x.getPrice()+y.getPrice())
//                .get();
        
        Double double1 = product.stream()
        .map(a -> a.getPrice())
        .reduce((x,y) -> x+y)
        .get();
                
         System.out.println("Total cost " + double1);
	}

}

class Product {
    private String name;
    private int quantity;
    private double price;
    

    Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    
    public int getQuantity() {
        return quantity;
    }
}