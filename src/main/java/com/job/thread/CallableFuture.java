package com.job.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFuture implements Callable<String> {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		List<Future<String>> list = new ArrayList<Future<String>>();
		
		Callable<String> callable = new CallableFuture();
		for (int i = 0; i < 100; i++) {

			Future<String> future = executor.submit(callable);
			list.add(future);
			
		}
		
		for (Future<String> f : list) {
			try {
				System.out.println(new Date() + "::"+ f.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		//shut down the executor service now
        executor.shutdown();
	}

	@Override
	public String call() throws Exception {
		Thread.sleep(5000);
		return Thread.currentThread().getName();
		
	}

}
