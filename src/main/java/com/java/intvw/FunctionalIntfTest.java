package com.java.intvw;

@FunctionalInterface
interface NumberComparator {
	boolean comparesNumbers(int x, int y);
}
public class FunctionalIntfTest {

	public static void main(String[] args) {
		NumberComparator c = (a,b) -> {
			if (a>b) return true;
			return false;
		};
		
		System.out.println(c.comparesNumbers(15, 10));
	}

}
