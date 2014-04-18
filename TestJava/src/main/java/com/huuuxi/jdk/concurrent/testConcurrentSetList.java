package com.huuuxi.jdk.concurrent;

import java.util.concurrent.CopyOnWriteArrayList;
/**
 * concurrent 包下的 集合 要么用 cas 要么用 lock();
 * 	cas 就是不停的取值，查找；
 * @author wyliujiangbin
 *
 */
public class testConcurrentSetList {

	public static void main(String[] args) {
		
	}
	/**
	 *  CopyOnWriteArrayList 原理就是，改变的时候，要先 加锁， 用新的数组保留旧数组，操作新数组，操作完毕把 旧数组赋值为新数组；
	 *   写少 读多的情况下性能最好
	 */
	public static void testCopyOnWriteList(){
		CopyOnWriteArrayList list;
	}
}
