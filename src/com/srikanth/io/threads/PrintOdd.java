package com.srikanth.io.threads;

public class PrintOdd implements Runnable{
	 int count = -1;
	    private Object common;

	    PrintOdd(Object common) {
	        this.common = common;
	    }

	    @Override
	    public void run() {
	        synchronized (common) {
	            while (count < 1000) {
	                try {
	                    common.notifyAll();
	                    count = count+2;
	                    System.out.println("OddThread--->"+count);
	                    common.wait();
	                } catch (InterruptedException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                }
	            }
	        }

	    }

}
