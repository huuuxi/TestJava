package com.huuuxi.jdk.thread;

public class TestExecutor {

	public static void main(String[] args) {
		testThread();
	}
	/**
	 * Url		:	http://www.importnew.com/10790.html
	 * 	生产者-消费者模式；中间需要一个存储者，Executor里面 的存储者就是 Queue，比如 ArraysBlockingQueue  LinkedBlockingQueue;
	 * 		生产者其实就是我们放入 线程的过程；消费者其实就是 线程执行完成的过程；
	 * 	1. 生成者过剩， Queue会满，需要 处理｛抛异常、取消、阻塞、执行...｝
	 * 		1). 抛异常，类似取消，会把任务丢掉，不建议；
	 * 		2). 执行，生产者不放入Queue，直接处理，变为消费者；隐患：处理过程中，消费者已经把队列处理完毕了，那么就会等待这个生产者；
	 * 		3). 阻塞，ExecutorPool里面默认不会阻塞，因为他调用的是，Queue的 offer(); 方案：处理Handler RejectHandler,然后调用 executor.getQueue().put(r); 就会阻塞；直到 生产者放入；
	 * 
	 */
	public static void testRejectHandler(){
		
	}
	/**
	 * 	Thread 构造函数，调用 init初始化：ThreadGroup、isDeamon、prorivty等
	 * 	 取Group，先取参数传的，然后取 securityManager里面取的，然后取当前线程的Group
	 * ThreadGroup 里面是可以有 其它的 Group的，是树形结构；父group是不可变的；
	 * 
	 */
	public static void testThread(){
		Thread thread;
		ThreadGroup group;
		System.out.println(Thread.activeCount());
	}
	
}
