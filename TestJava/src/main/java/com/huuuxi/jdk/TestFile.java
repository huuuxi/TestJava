package com.huuuxi.jdk;

import java.io.File;
import java.io.IOException;

public class TestFile {

	private final static  String STR = "d://a.txt";
	public static void main(String[] args) {
		testFile();
	}
	
	public static void testFile(){
		File  file = new File(STR);
		System.out.println(file.getAbsolutePath());
		try {
			System.out.println(file.getCanonicalPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
