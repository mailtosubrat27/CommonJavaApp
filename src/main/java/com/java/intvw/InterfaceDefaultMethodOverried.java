package com.java.intvw;

public class InterfaceDefaultMethodOverried implements Poet, Story, Song {

	public static void main(String[] args) {
		InterfaceDefaultMethodOverried obj = new InterfaceDefaultMethodOverried();
		obj.write();

	}

	@Override
	public void write() {
		// TODO Auto-generated method stub
		Poet.super.write();
	}
	

}

interface Poet {
	default void write() {
		System.out.println("Writting Poet.");
	}
}

//@FunctionalInterface
interface Story {
	default void write() {
		System.out.println("Writting Story.");
	}
}

interface Song {
	
}
