package com.srikanth.thread.io;

public class OddEvenThread {
	volatile static boolean oddPrinted = false;
	public static void main(String args[]){
		Object obj = new Object();
		Thread t1 = new Thread(new OddThread(obj,oddPrinted));
		t1.setName("OddThread");
		Thread t2 = new Thread(new EvenThread(obj,!oddPrinted));
		t2.setName("EvenThread");
		t1.start();
		t2.start();
	}

}
