package com.srikanth.thread.io;

public class OddThread implements Runnable{

	private Object object;
	private boolean oddPrinted;
	public OddThread(Object obj,boolean oddPrint){
		this.object = obj;
		this.oddPrinted = oddPrint;
	}
	@Override
	public void run() {
		
		for(int i=1;i<100;i=i+2){
			synchronized(object){				
				object.notify();
				System.out.println(Thread.currentThread().getName()+"----->"+i);
				oddPrinted = true;
				try {
					object.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
				}
				
		}
		
	}

}
