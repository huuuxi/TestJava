package com.huuuxi.jdk.concurrent;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
/**
 * 
 * @author wyliujiangbin
 *
 *	Deque 里面 使用的是 lock(); Deque 组成元素也有 first last ，LinkedList里面只有一个header是因为List里面是数组，环形列表可以接收；
 */
public class TestConcurrentLinkedQueue {

	public static void main(String[] args) {
		
	}
	/**
	 * 里面定义了两个 变量  head tail;
	 * 	也是用的 cas compareAndSet 和 原子类 Atomic一样；
	 * 	参考文章看了下，head用来读，tail用来写；
	 * 	tail写的时候，找到tail，但是tail不一定是尾节点，因为设置tail是允许失败；然后遍历查找tail尾节点，找到后来处理插入等；
	 * 
	 */
	public static void testConcurrentLinkedQueue(){
		
		ConcurrentLinkedQueue queue;
		Queue q;
	}
	/**
	 * Blocking Delay 下的都加 lock();
	 * 
	 */
	public static void testConcurrentLinkedBlockingDeque(){
		LinkedBlockingDeque deque;
		LinkedBlockingQueue queue;
		/**
		 * DelayQueue,PriorityBlockingQueue 实现用的是 PriorityQueue
		 * DelayQueue 实现用的是 PriorityQueue
		 */
		DelayQueue delayQueue;
		PriorityBlockingQueue priorityBlockingQueue; 
		/**
		 * 数组，固定大小，三个标志位，takeIndex、putIndex、count
		 */
		ArrayBlockingQueue arrayBlockingQueue;
		
	}
}
