package com.concept;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class FUnctionalIntfTest {

	public static void main(String[] args) {
		MyIntf aa = () -> System.out.println("-- Test --");
		aa.myMethod();
		
		BiFunction<Integer, String, String> concatenate = (num, str) -> num + ": " + str;
		String result = concatenate.apply(42, "Answer");
		System.out.println("BiFunction : "+ result);
		
		BinaryOperator<Integer> add = (a, b) -> a + b;
		int sum = add.apply(3, 4); // Result: 7
		System.out.println("Binary Operator:"+ sum);
		


	}
}

@FunctionalInterface
interface MyIntf {
	void myMethod();
}