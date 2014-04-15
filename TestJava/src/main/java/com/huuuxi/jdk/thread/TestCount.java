package com.huuuxi.jdk.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class TestCount {

	public static AtomicInteger i = new AtomicInteger(0);
	public static Integer j = 0;
	
	public static void main(String[] args) throws InterruptedException {
		for(int m = 0;m<100;m++){
			new Thread(){
				@Override
				public void run() {
					for(int n = 0;n<1000;n++){
						j++;
					}
				}
			}.start();
		}
		
		/*for(int m = 0;m<100;m++){
			Thread thread = new Thread(new MyRunnabled());
			thread.start();
		}*/
		
		
		Thread.sleep(1000);
		System.out.println(i);
		System.out.println(j);
		
	}
	
	
}
class MyRunnabled implements Runnable{

	@Override
	public void run() {
		for(int m = 0;m<100;m++){
			TestCount.i.incrementAndGet();
			TestCount.j++;
		}
		
	}
	
}

