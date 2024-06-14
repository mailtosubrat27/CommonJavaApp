package com.concept;

public class TryCatchTest {

	public static void main(String[] args) {
		System.out.println("Line 1");
		System.out.println("Returned : "+ tryStatement());
		
		System.out.println("End..");
		

	}

	private static int tryStatement() {
		try {
			System.out.println("Line 2");
//			System.exit(1);
//			throw new ArrayIndexOutOfBoundsException();
//			System.out.println("Line 3");
			return 4;
		} catch (NullPointerException fne) {
			System.out.println("NullPointerException");
			
		} catch (ArrayIndexOutOfBoundsException ab) {
			System.out.println("ArrayIndexOutOfBoundsException");
			return 2;
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException");
			return 3;
		}
		catch (Exception e) {
			System.out.println("Exception");
		} finally {
			System.out.println("Finally ...");
			return 1;
		}
		
//		return 0;
	}

}
