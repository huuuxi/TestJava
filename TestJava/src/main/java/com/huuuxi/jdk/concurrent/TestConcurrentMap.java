package com.huuuxi.jdk.concurrent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * 
 * @author wyliujiangbin
 *	ConcurrentMap 增加了桶segment机制，每个桶里面都是lock() 调用；锁用的是 ReentrantLock 继承
 *	
 * 取count: 取两次count，然后比较，如果改变了，那么就加锁取真正的count；
 * get的时候，第一次不需要加锁，只有取到为null的时候才加锁；
 * 为什么读get不需要加锁，因为happen-before原则，要求其能够保证写在前；
 * 
 * 扩容，segment的扩容是这样达到的，他是先添加，然后判断是否需要扩容，这样就避免了 加入没有添加而扩容了；
 * 
 * 几个名次：偏移量、掩码
 */
public class TestConcurrentMap {

	public static void main(String[] args) {
		
	}
	
	public static void testConcurrentMap(){
		ConcurrentMap map;
	}
	/**
	 * 	里面定义了segment，是一个数组，put，add ，remove根据key取到hash，去取 segment的数组的位置，然后调用这个segment的put，里面实现用的lock()；
	 * 	segment 继承了 ReetrantLock；
	 * 	其实他的操作基本全是  segment的操作；
	 * 	
	 * 	取size和有意思，不是各个segment的count相加，而是 首先 取两次 count的和，然后看是否变化，如果变化就 锁，然后重新取；
	 * 	取是否有修改，只需要求 modCount而已；
	 * 	
	 */
	public static void testConcurrentHashMap(){
		ConcurrentHashMap map;
	}
	/**]
	 * ConcurrentSkipListMap 里面实现用的 是 SkipList 跳表，相对 TreeMap的红黑树，在并发的时候好一些；
	 * 
	 */
	public static void testConcurrentSkipListMap(){
		ConcurrentSkipListMap map;
	}
}
