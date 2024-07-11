package com.java.test;

public class Logics {
	public static void main(String[] args) {
		//Reverse a number
		System.out.println(reverseNum(509));
		
		
	}

	private static int reverseNum(int num) {
		int res = 0;
		while(num != 0) {
			res = res*10 + (num%10);
			num /= 10;
		}
		return res;
	}
}
