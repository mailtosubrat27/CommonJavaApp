package com.concept;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
	
		ExecutorService executor = Executors.newFixedThreadPool(10);
		
		Runnable runnableTask = () -> {
		    try {
		        TimeUnit.MILLISECONDS.sleep(300);
		        System.out.println("--- Runnable ---");
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		};

		Callable<String> callableTask = () -> {
		    TimeUnit.MILLISECONDS.sleep(300);
		    return "Task's execution";
		};

		List<Callable<String>> callableTasks = new ArrayList<>();
		callableTasks.add(callableTask);
		callableTasks.add(callableTask);
		callableTasks.add(callableTask);
		
		executor.execute(runnableTask);
		Future<String> flist = executor.submit(callableTask);
        System.out.println("future.get = " + flist.get()); 
        
        List<Future<String>> futures =  executor.invokeAll(callableTasks);
        for(Future<String> future : futures){  
            System.out.println("##future.get = " + future.get());  
        }  
         
        
        

	}

}
