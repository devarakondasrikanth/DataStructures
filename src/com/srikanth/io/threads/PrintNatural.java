package com.srikanth.io.threads;

public class PrintNatural {
	public static void main(String args[]) {
        Object obj = new Object();
        Runnable r = new PrintOdd(obj);
        Thread printOdd = new Thread(r);
        printOdd.setName("OddThread");
        Runnable r2 = new PrintEven(obj);
        Thread printEven = new Thread(r2);
        printEven.setName("EvenThread");
        printOdd.start();
        printEven.start();

    }

}
