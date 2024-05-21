package com.job.thread;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class SimpleCallableExample {
    public static void main(String[] args) {
        // Step 1: Implement the Callable interface
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                // Perform some computation
                int sum = 0;
                for (int i = 1; i <= 10; i++) {
                    sum += i;
                }
                return sum; // Return the result of the computation
            }
        };

        // Step 2: Wrap the Callable with FutureTask
        FutureTask<Integer> futureTask = new FutureTask<>(callable);

        // Step 3: Create and start a Thread
        Thread thread = new Thread(futureTask);
        thread.start();

        // Step 4: Retrieve the result
        try {
            Integer result = futureTask.get(); // This will block until the result is available
            System.out.println("Sum of first 10 numbers: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
