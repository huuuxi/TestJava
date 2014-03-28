package com.huuuxi.http;

public class TestDownload {

	public static String URL = "https://merchant3.chinabank.com.cn:9103/billfiles/22313716_20140305_accountBill.xls";
	public static void main(String[] args) {
		testDown();
	}
	public static void testDown(){
		HttpClientUtil client = new HttpClientUtil();
		String str = client.sendPostRequest(URL, "");
		System.out.println("str:" +str);
		String string = client.sendPostRequest("https://www.google.com.hk/search?q=a&oq=a&aqs=chrome..69i57j69i60l3j69i59j69i60.3604j0j7&sourceid=chrome&es_sm=122&ie=UTF-8", "");
		System.out.println("String:" + string);
		
	}
}
