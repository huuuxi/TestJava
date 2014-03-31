package com.huuuxi.jdk.collections;

import java.io.IOException;
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
		Runtime r = Runtime.getRuntime();
		System.out.println(r.freeMemory()/1000000);
		r.gc();
		System.out.println(r.availableProcessors());
		System.load("c://d.txt"); // dll 文件
		System.loadLibrary("abc");
		try {
			r.exec("notepad");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
