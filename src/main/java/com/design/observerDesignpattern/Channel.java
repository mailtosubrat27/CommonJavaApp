package com.design.observerDesignpattern;

import java.util.ArrayList;
import java.util.List;

public class Channel implements Subject {
	private List<Subscriber> subs = new ArrayList<Subscriber>();
	String name;
	
	public void subscribe(Subscriber sub) {
		subs.add(sub);
	}
	
	public void unSubscribe(Observer sub) {
		subs.remove(sub);
	
	}
	
	public void notifySubscribers() {
		
		for(Subscriber sub : subs) {
			sub.update();
		}
	}
	
	public void upload(String name) {
		this.name = name;
		notifySubscribers();
	}

}
