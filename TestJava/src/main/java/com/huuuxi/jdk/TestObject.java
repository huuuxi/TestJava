package com.huuuxi.jdk;

public class TestObject {

	public static void main(String[] args) {
//		testZ();
//		testInterger();
		testClone();
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
	
	/**
	 * Integer 会缓存 -128~127 数字，故得到的地址是一样的；
	 */
	public static void testInterger(){
		Integer a = 130;
		Integer b = 130;
		System.out.println(a == b);
		Integer c = new Integer(100);
		Integer d = new Integer(100);
		System.out.println(c == d);
	}
	
	public static void testClone(){
		Strings s = new Strings();
		s.ts = "111";
		Strings ss = s.clone();
		System.out.println(s == ss);
		System.out.println(ss.ts);
	}
}

class Strings implements Cloneable{
	String ts ;
	public Strings clone(){
		try {
			return (Strings) super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("eee");
			e.printStackTrace();
			return null;
		}
	}
}
