package com.huuuxi.jdk.collections;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author admin
 *
 */
public class TestCollections {

	public static void main(String[] args) {
		testCollection();
	}
	public static void testCollection(){
		System.out.println(System.getenv("JAVA_HOME"));
		System.out.println(System.getProperties());
		// 看到 Collections 方法，自然用到了 Arrays里面方法；
		Collections collections;
		Arrays arrays;
		Arrays.copyOf(new int[]{1}, 2);
		//使用的是System.arraycopy
		int[] a = {}; int b[] = {};
		System.arraycopy(a, 0, b, 0, 1);
		// 
		System.out.print(true);
		
		
	}
}
