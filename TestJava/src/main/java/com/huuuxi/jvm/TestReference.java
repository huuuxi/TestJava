package com.huuuxi.jvm;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
/**
 * 
 * @author admin
 *	引用分为四种：强 软 弱 虚
 */
public class TestReference {

	public static void main(String[] args) {
		
	}
	/**
	 *  SoftReference 和 ReferenceQueue 联合使用很巧妙；
	 */
	public static void testSoftReference(){
		Reference ref ;
		ReferenceQueue queue = new ReferenceQueue<SoftReference<String>>();
		SoftReference<String> str = new SoftReference<String>("111", queue);
		
		while((ref = queue.poll()) != null){ 
			/**
			 * 通过 取 ReferenceQueue里面的 引用来判断，软引用是否已经被回收了；
			 */
		}
		
		
	}
}
