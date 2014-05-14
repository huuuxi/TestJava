package com.huuuxi.jdk.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wyliujiangbin
 *
 */
public class TestLock {

	public static void main(String[] args) {
		
	}
	
	public static void testReentrantLock(){
		/**
		 * ReentrantLock 实现了 sync 也就是AQS，分为 公平锁和非公平锁，NonfairSync、FairSync
		 * Condition 可以理解为一个单独的 条件队列，里面有await() signal() signalAll() ; 用于阻塞和唤醒，替代object里面的 wait notify
		 * 线程竞争可以，先获取 Condition，如果条件不满足，加入到队列，知道满足后，signal后，把他唤醒，去竞争锁！可能需要加入的AQS队列；竞争完毕开始执行；
		 */
		ReentrantLock reentrantLock;
		/**
		 * 基础信息 Lock 里面定义了 lock，unlock等方法；是锁必须提供的；
		 *  LockSupport 里面是 Lock的一个支持，是对 Object的一个提升，扩展，park unpark；
		 *  Condition 的signal 实际上就是 调用的LockSupport的 unpark
		 *  Lock 的实现 比如 ReadLock等，也是调用AQS调用 LockSupport的 park，只是AQS自己添加了 队列Node来存储线程；
		 *
		 *	Lock 和 Condition 一起使用；	
		 *
		 * ps: wait 和park的区别在于，wait阻塞前，必须synchronized；而park会有许可证明一项，即不需要判断是否当前线程有wait()权限，线程安排，排斥了 死锁可能；
		 */
		Lock lock;
	}
}
