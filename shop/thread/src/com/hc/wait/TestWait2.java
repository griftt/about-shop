package com.hc.wait;

public class TestWait2 {

	public static void main(String[] args) {
		final String str = "";

		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println("in run");
				synchronized (str) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		};

		new Thread(r).start();
	}

}
