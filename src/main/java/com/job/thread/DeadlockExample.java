package com.job.thread;

public class DeadlockExample {
    public static void main(String[] args) {
        final Object resource1 = "Resource 1";
        final Object resource2 = "Resource 2";

        // Thread 1
        Thread t1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1: locked resource 1");

                // Pause to make sure thread 2 can lock resource 2
                try { Thread.sleep(100); } catch (InterruptedException e) {}

                System.out.println("Thread 1: waiting for resource 2");

                synchronized (resource2) {
                    System.out.println("Thread 1: locked resource 2");
                }
            }
        });

        // Thread 2
        Thread t2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2: locked resource 2");

                // Pause to make sure thread 1 can lock resource 1
                try { Thread.sleep(100); } catch (InterruptedException e) {}

                System.out.println("Thread 2: waiting for resource 1");

                synchronized (resource1) {
                    System.out.println("Thread 2: locked resource 1");
                }
            }
        });

        // Start the threads
        t1.start();
        t2.start();
    }
}