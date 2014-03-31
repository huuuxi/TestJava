package com.huuuxi.jdk.thread;


public class TestThreadWait {

	public static void main(String[] args) {
		ThreadB b = new ThreadB();
		b.start();
		synchronized (b) {
			try {
				b.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("a call b:"+b.totle);
	}
}
class ThreadB extends Thread{
	int totle = 0;
	@Override
	public void run() {
		//当在对象上调用wait()方法时，执行该代码的线程立即放弃它在对象上的锁。然而调用notify()时，并不意味着这时线程会放弃其锁。如果线程荣然在完成同步代码，则线程在移出之前不会放弃锁。因此，只要调用notify()并不意味着这时该锁变得可用
		synchronized (this) {
			for(int i = 0 ; i< 101; i++){
				try {
					Thread.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				totle += i;
			}
			System.out.println(totle);
			//notifyAll();
			try {
				Thread.sleep(200000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
