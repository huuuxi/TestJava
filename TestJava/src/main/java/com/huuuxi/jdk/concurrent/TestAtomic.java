package com.huuuxi.jdk.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @author wyliujiangbin
 *	Atomic 是一个cas，compareAndSet 规则；
 *	volatile 只能保证 可见性，不能保证 互斥性；
 *	atomic 里面 引用了 volatile变量；
 */
public class TestAtomic {

	public static void main(String[] args) {
		
	}
	/**
	 * 原理就是一直for循环，直到 compareAndSet成功，return跳出for；
	 * 
	 */
	public static void testAtomic(){
		AtomicInteger integer;
	}
	
}
