package com.srikanth.thread.io;

public class PrintEvenOdd {

    public static void main(String ... args){
    Printer print = new Printer();
    Thread t1 = new Thread(new TaskEvenOdd(print, 100,  false));
    Thread t2 = new Thread(new TaskEvenOdd(print, 100, true));
    t1.start();
    t2.start();
}
    
}