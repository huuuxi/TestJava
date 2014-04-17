package com.huuuxi.jdk.collections;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @author wyliujiangbin
 *		Map 不能放 重复key；替换了 接口Dictionary；
 *			entrySet() 比 keySet() 效率高，都是遍历；
 *			put() 很有意思，他返回的是 前一个值；
 *			containsValue()  values();
 */
public class TestMap {

	public static void main(String[] args) {
		testMap();
	}
	
	public static void testMap(){
		Map map = new HashMap<String, String>();
		Object obj = map.put("1", 1);
		Object obj2 = map.put("1", "2");
		System.out.println(obj);
		System.out.println(obj2);
		System.out.println(map.remove(3));
	}
}
