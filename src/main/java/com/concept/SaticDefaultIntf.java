package com.concept;

public class SaticDefaultIntf implements MyInterface {
	@Override
	public void regularMethod() {
		System.out.println("Implementation of regularMethod");
	}

	public static void main(String[] args) {
		SaticDefaultIntf sa = new SaticDefaultIntf();
		sa.regularMethod();
		sa.defaultMethod();
		MyInterface.staticMethod();
		MyInterface sa1 = new SaticDefaultIntf();
		
	}
}

interface MyInterface {
	void regularMethod(); // This is a regular abstract method

	default void defaultMethod() {
		System.out.println("Default implementation of defaultMethod");
	}
	static void staticMethod() {
        System.out.println("Static method in interface");
    }

}
