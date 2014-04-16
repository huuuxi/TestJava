package com.huuuxi.jdk;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * 
 * @author wyliujiangbin
 *	
 *	url : location 注重协议；
 *	uri ： 注重资源表示；
 *
 *	url 在处理 地址的时候，截取 ? # 用到了 一个内部类，很有意思；
 *	url 处理类有 handler，协议handler
 *
 *	uri 处理则是用了 私有类 Parser
 */
public class TestUrlUri {

	public static void main(String[] args) {
		testUrl();
	}
	
	public static void testUrl(){
		String str = "http://www.jd.com:81/abc.html?id=1#12";
		String f = "d://txt.txt";
		try {
			URL url = new URL(str);
			File file  = new File(f);
			System.out.println(url.toString());
			System.out.println(url.toURI());
			System.out.println(file.toURI());
			System.out.println(file.toURL());
			URI uri = URI.create(str);
			System.out.println(uri);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
