package com.srikanth.io.threads;

public class ThreadPoolTest{
    public static void main(String[] args) throws Exception {
           ThreadPool threadPool=new ThreadPool(20); //create 2 threads in ThreadPool 
           Runnable task=new Task();
           for(int i=0;i<200;i++){
           threadPool.execute(task);
          // threadPool.execute(task);
           }
          threadPool.shutdown();
    }
    
}
