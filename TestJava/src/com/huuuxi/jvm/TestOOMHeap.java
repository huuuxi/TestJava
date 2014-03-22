package com.huuuxi.jvm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**   
 * @Title: TestOOMHeap.java 
 * @Description: 
 * @author huuuxi 
 * @Email huuuxi@gmail.com 
 * @date 2014-3-22 上午2:41:18 
 */
public class TestOOMHeap {

	public static void main(String[] args) {
		//testOOM();
		testPerm();
	}
	public static void testOOM(){
		Map<String, Pilot> map = new HashMap<String, Pilot>();
		Object[] array = new Object[1000000];
		for(int i=0;i<1000000;i++){
			String d = new Date().toString();
			Pilot p = new Pilot(i, d);
			map.put(i+"hu", p);
			array[i] = p;
		}
	}
	public static void testPerm(){
		Object[] objs = new Object[10000000];
		for(int i = 0; i< 10000000;i++){
			String s = String.valueOf(i).intern();
			objs[i] = s;
		}
	}
	
}
