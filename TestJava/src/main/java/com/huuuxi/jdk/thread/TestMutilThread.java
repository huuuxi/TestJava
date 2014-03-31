package com.huuuxi.jdk.thread;

/**
 * @author wyliujiangbin
 *	在同步程序块内调用yeild方法让出CPU资源也没有意义，因为你占用着锁，其他互斥线程还是无法访问同步程序块。当然与同步程序块无关的线程可以获得更多的执行时间。
 *
 *	ps：wait() ，首先必须有对象的锁，然后释放对象锁，等待对象的notify()方法唤醒当前线程；
 */
public class TestMutilThread {

	public static void main(String[] args) {
		//testJoin();
		testDaemon();
		System.out.println("all is over!");
	}
	
	/**
	 *  守护进程，会在所有进程运行完毕后，自动结束，而不管守护进程是否执行完毕；
	 */
	public static void testDaemon(){
		MyThread myThread = new MyThread();
		Thread demon = new Thread(new MyRunnables());
		demon.setDaemon(true);
		myThread.start();
		demon.start();
	}
	
	/**
	 * join 会把 目标线程 加入到当前线程前面；调用栈的插入；
	 */
	public static void testJoin(){
		MyThread mythead = new MyThread();
		mythead.start();
		for (int i = 0; i <5; i++) {
			System.out.println("主线程运行："+i);
			if (i > 2) {
				try {
					mythead.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
class MyThread extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("线程运行："+i);
		}
	}
}
class MyRunnables implements Runnable{
	@Override
	public void run() {
		for (int i = 0; i < 11111; i++) {
			System.out.println("后台线程，守护线程运行："+i);
		}
	}
	
}
