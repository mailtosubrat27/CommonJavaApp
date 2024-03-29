package com.java.intvw;

import java.util.Scanner;

//Check power of 2
public class PowerOf2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter no :");
		Integer num  = sc.nextInt() ;
		
		//using old java
		power2(num);
		
		System.out.println(verifyPowerOf2(num));
	}

	private static void power2(Integer num) {
		Boolean flag = false;
		while(true) {
			if(num%2 == 0) {
				num = num /2;
				if(num == 1) {
					flag = true;
					break;
				}
			} else {
				break;
			}
		}
		
		if(flag) 
			System.out.println("power of 2");
		else {
			System.out.println("not");
		}
	}
	
	public static boolean verifyPowerOf2(Integer num) {
		if( num <= 0) {
			return false;
		}
		while(num >1 ) {
			if(num%2 !=0) {
				return false;
			}
			num /= 2;
		}
		return true;
	}

}
