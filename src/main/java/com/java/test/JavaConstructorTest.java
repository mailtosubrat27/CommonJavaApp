package com.java.test;

public class JavaConstructorTest {

	
	public static void main(String[] args) {
 		System.out.println("-----------");
		SuperClass reference = new SubClass();
        reference.foo();
	}

}

class SuperClass {
    SuperClass() {
    	System.out.println(" SuperClass constructor");
        foo();
    }

    public void foo() {
        System.out.println("In SuperClass.foo()");
    }
}

class SubClass extends SuperClass {
    private String member;

    public SubClass() {
    	System.out.println(" SubClass constructor");
        member = "HI";
    }

    public void foo() {
    	System.out.println(" SubClass foo 1---");
//        System.out.println("In SubClass.foo(): " + member.toLowerCase());
    }
}
