package com.huuuxi.jdk.file;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class ReadFile {

	public static void main(String[] args) {
		InputStream inputStream = null;
		String str = null;
		try {
			inputStream = new FileInputStream(new File("d://14.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			BufferedInputStream stream = new BufferedInputStream(inputStream);
			byte[] bs = new byte[1024];
			stream.read(bs);
			System.out.println(new String(bs,"utf-8"));
			
			System.out.println(new String(bs,"gbk"));
			
			
			
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"utf-8"));
			BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(inputStream,"gbk"));
			str = bufferedReader1.readLine();
			System.out.println(str);
			System.out.println(new String (str.getBytes("gbk"),"utf-8"));
					
//			System.out.println(bufferedReader.readLine());
//			System.out.println(bufferedReader1.readLine());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
