package com.concept.ooo;

public class OverridenClsIntf {

	public static void main(String[] args) {
		B b = new B();
		b.m();  //I2  Since B implements I2, it will inherit I2's default method m(), which overrides I1's m().(since I2 is more specific than I1).
		b.callM(); //I2  B implements I2 and does not override m(), the m() method from I2 is called (because I2 overrides the default method m() from I1).
		b.callSuperM(); // I1
		
		System.out.println("----------");
		A a = new B();
		a.m();   // I2    since I2 is more specific than I1
		a.callM();   //I2  B implements I2 and does not override m(), the m() method from I2 is called (because I2 overrides the default method m() from I1).
//		a.callSuperM(); //Compilation error -  by super cls reference we can not call to sub class instance methods but we call to overridden methods
		
		System.out.println("----------");
		A a1 = new A();
		a1.callM();
		a1.m();

		System.out.println("----------");
		//SKS
//		C c = new C();
//		c.m(); // print C
//		c.callSuperMethods();

	}

}

class A implements I1 {
	public void callM() {
		m();
	}
}

class B extends A implements I2 { // Since B implements I2, it will inherit I2's default method m(), which overrides I1's m().(since I2 is more specific than I1).
	public void callSuperM() {
		super.m();
	}
}

interface I1 {
	default void m() {
		System.out.println("I1 ");
	}
}

interface I2 extends I1 {
	default void m() {
		System.out.println("I2 ");
	}
}

//SKS

class C implements I2 {
	public void m() {
		System.out.println("C ");
	}

	public void callSuperMethods() {
		// Call the default method of I1
		// Use a helper class to call the default method of I1
        new I1() {}.m();

		// Call the default method of I2
		I2.super.m();  // To call interface default method m, we shoud use InterfaceName.super.methodName()
				// basically super is used for super CLASS
	}
}

class D implements I1, I2 {
	public void m() {
		System.out.println("D");
//		super.m(); // This can not call to super Interface m()
	}
}
