package com.hc.wait;

public class TestDealLock {

	// 死锁的例子
	public static void main(String[] args) {
		/*
		 * run() {
		 *   syn  (A) {
		 *       syn (B) {
		 *       }
		 *   }
		 *  }
		 */
		/*
		 * run() {
		 *   syn  (B) {
		 *       syn (A) {
		 *       }
		 *   }
		 *  }
		 */
		
		final String A = "aaa";
		final String B = "bbb";
		System.out.println(A == B);
		
		new Thread() {
			@Override
			public void run() {
				synchronized (A) {
					System.out.println("A is locked");
					try {
						 Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (B) {
						System.out.println("吃肉");
					}
				}
			}
		}.start();

		new Thread() {
			@Override
			public void run() {
				synchronized (B) {
					System.out.println("B is locked");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (A) {
					}
				}
			}
		}.start();
		
	}

}
