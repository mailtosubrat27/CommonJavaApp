package com.job.thread;

public class JavaYieldExp extends Thread {
/*
 If a thread wants to pass its execution to give chance to remaining threads of the same priority then we should go for yield()
 */
	 public void run()  
	    {  
	        for (int i=0; i<33 ; i++)  
	            System.out.println(Thread.currentThread().getName() + " in control");  
	    }  
	    public static void main(String[]args)  
	    {  
	        JavaYieldExp t1 = new JavaYieldExp();  
	        JavaYieldExp t2 = new JavaYieldExp();  
	        // this will call run() method  
	        t1.setName("First Thread");
	        t1.start();
	        t2.setName("Second Thread");
	        t2.start();  
	        for (int i=0; i<3; i++)  
	        {  
	            // Control passes to child thread  
	            t1.yield();  
	            System.out.println(Thread.currentThread().getName() + " in control");  
	        }  
	    }  
	}  
