package com.huuuxi.jdk;

public class TestObject {

	public static void main(String[] args) {
		testZ();
	}
	
	/**
	 * 	Clone() 方法是 返回当前对象的一个拷贝，有浅拷贝和深拷贝之分
	 * 	浅拷贝会把 对象的引用传递，当根引用对象改变，其它也会变；
	 *  深拷贝就是把把 对象的引用也调用 clone
	 */
	public static void testObject(){
		
	}
	
	public static void testZ(){
//			String t = "123";
//			String s = "321";
		Strings  t = new Strings();
		t.ts = "a";
		Strings s = new Strings();
		s.ts = "b";
		System.out.printf("t: %s, s: %s;\n",t.ts,s.ts);
			swap(t, s);
			System.out.printf("t: %s, s: %s;\n",t.ts,s.ts);
		
	}
	
	public static void swap(Strings t ,Strings s){
//		String temp = s.ts;
//		s.ts = t.ts;
//		t.ts = temp;
		Strings temp = s;
		s = t;
		t = temp;;
	}
}

class Strings {
	String ts ;
}
