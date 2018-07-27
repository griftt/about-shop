package com.hc.demo1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestPool {

	public static void main(String[] args) throws Exception {
		// ExecutorService service = Executors.newFixedThreadPool(3);

		ExecutorService service = Executors.newCachedThreadPool();
		
		for(int i =0; i < 7; i++) {
			Runnable r = new Task(i);
			service.submit(r);
		}
		
		// service.
		
		// Thread.sleep(6000);

		for(int i =0; i < 7; i++) {
			Runnable r = new Task(i);
			service.submit(r);
		}
		
		System.out.println("task is commited");
		
		service.shutdown();
	}

}

class Task2 implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {

		return 100;
	}
	
}

class Task implements  Runnable {
	
	int  num =0;
	
	public Task(int i) {
		num = i;
	}
	@Override
	public void run() {
		System.out.println("num is " + num + " " + Thread.currentThread());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(num + " will end");
	}
}
