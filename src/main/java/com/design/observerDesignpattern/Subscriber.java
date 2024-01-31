package com.design.observerDesignpattern;

public class Subscriber implements Observer {
	private String name;
	private Channel ch;
	
	public Subscriber(String name) {
		super();
		this.name = name;
	}

	public void update() {
		System.out.println("Hey "+name+", New Video update by Channel: "+ ch.name);
	}
	
	public void subscribeChannel(Channel ch) {
		this.ch = ch;
	}

}
