package com.concept;

@FunctionalInterface
interface Calculate {
	public abstract Integer addNum(Integer a, Integer b);
	default String showMessage(String str) {
		return "Showing this message for :"+str;
	}
}

class TaxCalculator implements Calculate {

	@Override
	public Integer addNum(Integer a, Integer b) {
		
		return a + b;
	}
	
}

class InterestCalculator implements Calculate {

	@Override
	public Integer addNum(Integer a, Integer b) {
		
		return a + b;
	}
	
	public String showMessage(String str) {  // overriding showMessage, not required to implement all interface
		return "InterestCalculator for :"+str;
	}
	
}

class EMICalculator implements Calculate {

	@Override
	public Integer addNum(Integer a, Integer b) {
		
		return a + b;
	}
	
}



public class FunctionalIntfDefaultMethod {

	public static void main(String[] args) {
		Calculate c = (a,b) -> a+b;  // Implementing addNum method using Lambda
		Integer x = c.addNum(3,5);
		System.out.println(x);
		
		// Default method usecase
		TaxCalculator tc = new TaxCalculator();
		System.out.println(tc.addNum(4, 4));
		System.out.println(tc.showMessage("TacCalculator"));
		
		InterestCalculator ic = new InterestCalculator();
		System.out.println(ic.addNum(4, 4));
		System.out.println(ic.showMessage("Home Loan"));
		
	}

}
