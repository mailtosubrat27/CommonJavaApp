package com.design.observerDesignpattern;

/* This is one-to-many relationship between Subject and observer.When any
 changes happen in Subject it notify to all observer
 
 Ex- Youtube channel has many subscriber. once any new video uploaded, it notifies to all subscribers
	Channel- Subject
    Subscriber - Observer
 */
public class ObserverDPMain {

	public static void main(String[] args) {
		Subscriber s1 = new Subscriber("Rkesh");
		Subscriber s2 = new Subscriber("Harsh");
		Subscriber s3 = new Subscriber("Sonu");
		Subscriber s4 = new Subscriber("Radhika");
		Subscriber s5 = new Subscriber("Bharath");
		
		Channel channel = new Channel();
		channel.subscribe(s1);
		channel.subscribe(s2);
		channel.subscribe(s3);
		channel.subscribe(s4);
		channel.subscribe(s5);
		
		s1.subscribeChannel(channel);
		s2.subscribeChannel(channel);
		s3.subscribeChannel(channel);
		s4.subscribeChannel(channel);
		s5.subscribeChannel(channel);
		
		
		channel.upload("Observer design pattern");
		
		
		

	}

}
