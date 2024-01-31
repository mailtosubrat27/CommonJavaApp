package com.concept;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ExecutorServiceShutdownTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService exs = Executors.newFixedThreadPool(3);
		Callable<String> c1 = () -> {
			return "Callable-C1";
		};

		Callable<String> c2 = () -> {
//			Thread.sleep(8000);
			return "Callable-C2";
		};

		Callable<String> c3 = () -> {
//			Thread.sleep(3000);
			return "Callable-C3";
		};

		List<Callable<String>> callList = new ArrayList<Callable<String>>();
		callList.add(c1);
		callList.add(c2);
		callList.add(c3);
		List<Future<String>> futureList = exs.invokeAll(callList);
		//////////
		System.out.println(new Date());
		IntStream.range(0, 11).forEach(i -> {
			exs.submit(new RunnableServ(i));
		});
		
		exs.shutdown();
//		exs.shutdownNow();
		exs.awaitTermination(1, TimeUnit.MINUTES);
		System.out.println(new Date());


	}

}

class RunnableServ implements Runnable {
	int i = 0;

	RunnableServ(int i) {
		this.i = i;
	}

	public void run() {

		try {
			Thread.sleep(5000);
			System.out.println(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
