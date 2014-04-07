package com.huuuxi.jdk;

import java.util.Arrays;

public class TestString {

	private static final String url = "https://merchant3.chinabank.com.cn:9103/billfiles/%s/%s_%s_accountBill.xls";
	public static void main(String[] args) {
		//testFormat();
		testString();
	}
	
	public static void testFormat(){
		String u = String.format(url, "111","222","333");
		String usub = url.substring(url.lastIndexOf("/")+1);
		System.out.println(usub);
		System.out.println(u);
	}
	/**
	 * 	split 调用的是index substring，添加到List里
	 * 	ps：返回值不是 基本类型，绝大部分调用内部方法；其它调用System Arrays 和构造方法，以及char[]
	 * trim 调用的是 substring
	 *  Arrays.copyof  和 System.copyof 
	 */
	public static void testString(){
		//System.out.println(String.CASE_INSENSITIVE_ORDER.compare("abc", "ABC"));
		System.out.println(Arrays.copyOf(new char[]{'1','2','3'}, 2));
		System.out.println(Arrays.copyOfRange(new char[]{'1','2','3','4','5'}, 2,4));
		char[] a = new char[]{'1','2','3','4','5'};
		char[] b = new char[4];
		System.arraycopy(a, 2, b, 1, 3);	
		System.out.println(String.valueOf(b));
		String ttt = "" ;
		System.arraycopy("123456", 1, ttt, 0, 3);
		System.out.println(ttt);
	}
}
