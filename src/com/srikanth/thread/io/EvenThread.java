package com.srikanth.thread.io;

public class EvenThread implements Runnable{
	private Object object = null;
	private boolean oddPrinted;
	public EvenThread(Object obj,boolean oddPrint){
		this.object = obj;
		this.oddPrinted = oddPrint;
	}
	@Override
	public void run() {
		
		for(int i=2;i<100;i=i+2){
			synchronized(object){
				
				object.notify();
				System.out.println(Thread.currentThread().getName()+"----->"+i);
				oddPrinted = false;
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
