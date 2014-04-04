package com.huuuxi.jdk;

public class TestString {

	private static final String url = "https://merchant3.chinabank.com.cn:9103/billfiles/%s/%s_%s_accountBill.xls";
	public static void main(String[] args) {
		testFormat();
	}
	
	public static void testFormat(){
		String u = String.format(url, "111","222","333");
		String usub = url.substring(url.lastIndexOf("/")+1);
		System.out.println(usub);
		System.out.println(u);
		
	}
}
