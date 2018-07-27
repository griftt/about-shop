package com.hc.sp;

public class TestSP {

	public static void main(String[] args) {
		SalePoint sp = new SalePoint();
		Thread t1 = new Thread(sp);
		Thread t2 = new Thread(sp);
		Thread t3 = new Thread(sp);
		t1.start();
		t2.start();
		t3.start();
	}

}
