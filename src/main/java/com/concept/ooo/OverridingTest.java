package com.concept.ooo;


class SuperCls {
	public void show() {
		System.out.println("SuperCls");
	}
}

class SubCls extends SuperCls implements TestInf{
	public void show() {
		System.out.println("Subcls");
		super.show(); // this way we can call to super class overridden method. By using subcls object we can not call to super class overridden methods
	}
}

interface TestInf {
	default void print() {
		System.out.println("-- default print -- ");
	}
}

public class OverridingTest {

	public static void main(String[] args) {
		
		SuperCls s = new SubCls();
		s.show();
		
		SubCls sc = new SubCls();
		sc.print();
	}
	
	

}
