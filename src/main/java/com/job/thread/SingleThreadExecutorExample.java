package com.job.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SingleThreadExecutorExample {
    public static void main(String[] args) {
        // Step 1: Create a single-threaded ExecutorService
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // Step 2: Define a Callable task
        Callable<String> callableTask = new Callable<String>() {
            @Override
            public String call() throws Exception {
                // Simulate some computation or processing
                Thread.sleep(1000);
                return "Task's execution result";
            }
        };

        // Step 3: Submit the Callable task to the executor
        Future<String> future = executorService.submit(callableTask);

        // Step 4: Retrieve the result
        try {
            String result = future.get(); // This will block until the result is available
            System.out.println("Result from callable task: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Shutdown the executor service
            executorService.shutdown();
        }
    }
}
