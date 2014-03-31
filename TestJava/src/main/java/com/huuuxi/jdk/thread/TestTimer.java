package com.huuuxi.jdk.thread;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import ch.qos.logback.core.util.TimeUtil;

/**
 * @author admin
 *	Timer 和 TimerTask
 *	TimerTask实现了Runnable，故能够是多线程
 *	Timer包含多个TimerTask，但是有顺序，如果需要多个TimerTask同时执行，需要建立多个Timer
 *	 自JDK5之后，可以用ScheduledThreadPoolExecutor来替代Timer。
 */
public class TestTimer {

	static class MyTimerTask extends TimerTask{

		@Override
		public void run() {
			System.out.println("my TimerTask boold;");
		}
		
	}
	
	public static void main(String[] args) {
		//testTimer();
		testScheuldThread();
	}
	
	public static void testTimer(){
		Timer timer1 = new Timer();
		MyTimerTask myTimerTask = new MyTimerTask();
		timer1.schedule(myTimerTask, 2000);
	}
	
	public static void testScheuldThread(){
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
		executorService.execute(new MyTimerTask());
		executorService.schedule(new MyTimerTask(), 20,TimeUnit.SECONDS);
		executorService.shutdown();
	}
	
}
