package com.hc.wait;

import java.util.Random;

class Customer {
	int amount = 10000;

	// 取钱
	synchronized void withdraw(int amount) {
		System.out.println("going to withdraw...");

		while (this.amount < amount) {
			System.out.println("Less balance; waiting for deposit...");
			try {
				wait();
			} catch (Exception e) {
			}
		}
		this.amount -= amount;
		System.out.println("withdraw completed... " + this.amount);
		notifyAll();
	}

	// 存钱
	synchronized void deposit(int amount) {
		System.out.println("going to deposit...");
		this.amount += amount;
		while (this.amount > 20000) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("deposit completed... " + this.amount);
		notify();
	}
}

public class TestWait {
	public static void main(String args[]) {
		final Customer c = new Customer();
		final Random random = new Random();

		Runnable with = new Runnable() {
			public void run() {
				while(true) {
					c.withdraw(500 + random.nextInt(4500));
					try {
						Thread.sleep(1000 + random.nextInt(1000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		Runnable depo = new Runnable() {
			public void run() {
				while(true) {
					c.deposit(500 + random.nextInt(4500));
					try {
						Thread.sleep(1000 + random.nextInt(1000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		new Thread(with).start();
		new Thread(with).start();
		new Thread(with).start();
		new Thread(depo).start();
		new Thread(depo).start();
	}
}
