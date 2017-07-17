package com.srikanth.io.threads;

public class PrintEven implements Runnable {
	int count = 0;
    private Object common;

    PrintEven(Object common) {
        this.common = common;
    }

    @Override
    public void run() {
        synchronized (common) {
            while (count < 1000) {
                try {
                    common.notifyAll();
                    count=count+2;
                    System.out.println("EvenThread--->"+count);
                    common.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

    }
}
