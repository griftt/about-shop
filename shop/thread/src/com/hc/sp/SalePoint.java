package com.hc.sp;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SalePoint implements Runnable {
	public int ticketNum = 30;
	public Random random = new Random();
	Lock lock = new ReentrantLock();
	// String lock ;

	@Override
	public void run() {

		while (ticketNum > 0) {
			// this ： 只要是 对象 就可以
			synchronized ("aaa") {
			// lock.lock();
				System.out.println(Thread.currentThread() + "卖 第 " + ticketNum + "张 票");
				ticketNum--;
				if (ticketNum == 10) {
					break;
				}
			// lock.unlock();
			}
			// saleOne();
			try {
				Thread.sleep(random.nextInt(2000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// this 
	public synchronized void saleOne() {
		System.out.println(Thread.currentThread() + "卖 第 " + ticketNum + "张 票");
		ticketNum--;
	}
	
	public synchronized void show() {
		System.out.println("aaa");
	}

}
