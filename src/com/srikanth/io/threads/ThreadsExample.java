package com.srikanth.io.threads;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadsExample implements Runnable {
    static int counter = 1; // a global counter

    static ReentrantLock counterLock = new ReentrantLock(true); // enable fairness policy

    static void incrementCounter(){
        counterLock.lock();

        // Always good practice to enclose locks in a try-finally block
        try{
            System.out.println(Thread.currentThread().getName() + ": " + counter);
            counter++;
        }finally{
             counterLock.unlock();
        }
     }

    @Override
    public void run() {
        while(counter<1000){
            incrementCounter();
            try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }

    public static void main(String[] args) {
        ThreadsExample te = new ThreadsExample();
        Thread thread1 = new Thread(te);
        Thread thread2 = new Thread(te);
        thread1.setName("oddThread");
        thread2.setName("EvenThread");
        thread1.start();
        thread2.start();          
    }
}