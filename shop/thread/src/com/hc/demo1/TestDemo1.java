package com.hc.demo1;

public class TestDemo1 {

	public static void main(String[] args) {
		One one = new One();
		One one2 = new One();
		one.start();
		one2.start();
		// one.start();
		Two two =new  Two();
		Thread t1 = new Thread(two);
		Thread t2 = new Thread(two);
		t1.start();
		t2.start();
		
		// t1 = null;
	}
}

class One extends Thread {
	@Override
	public void run() {
		System.out.println("in thread One");
	}
}
 
class Two implements Runnable {
	public void run() {
		System.out.println("in thread two");
	}
}
