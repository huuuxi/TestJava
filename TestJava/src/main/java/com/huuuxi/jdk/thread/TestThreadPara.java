package com.huuuxi.jdk.thread;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.httpclient.HttpClient;

public class TestThreadPara {

	
	public static void main(String[] args) {
		for(int i =0 ; i< 1000 ;i++){
			test();
		}
	}
	
	public static void test(){
		System.out.println("hello");
//		try {
//			Thread.currentThread().sleep(100);
//			
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			URL url = new URL("http://www.baidu.com");
			URLConnection connection = url.openConnection();
			System.out.println(connection.getContent());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("world");
	}
}
