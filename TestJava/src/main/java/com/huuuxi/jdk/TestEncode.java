package com.huuuxi.jdk;

import java.net.URLEncoder;

public class TestEncode {

	public static void main(String[] args) {
		testEncode();
	}
	
	public static void testEncode(){
		String en = URLEncoder.encode(">");
		System.out.println(en);
	}
}
