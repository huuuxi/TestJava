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
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ReadFile {

	public static void main(String[] args) throws UnsupportedEncodingException {
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(new File("d://14.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		byte[] b = new byte[1024];
        int totalSize = 0;
        String str = null;
        String encode = null;
        String[] encodes = new String[]{"gbk","utf-8","iso-8859-1","utf-16","unicode","gb2312"};
        StringBuffer stringBuffer = new StringBuffer();
        int rows = 0;
        int bc = 0;
        byte[] bytes = new byte[700*1024];
        int total = 0;

        try {
        	 BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
             if ((bc=bufferedInputStream.read(b)) >= 0){
                 for(String en : encodes){
                	 str = new String(b,en);
                	 if (str.contains("银行")) {
						encode = en;
						System.out.println(encode);
						break;
					}
                 }
                 
                 System.arraycopy(b, 0, bytes, total, bc);
                 total +=bc;
                 while ((bc = bufferedInputStream.read(b)) != -1) {
//                     stringBuffer.append(new String(b,0,bc,encode));
                     System.arraycopy(b, 0, bytes, total, bc);
                     total += bc;
                     if (total > 600*1024) { //每次是 1024字节，2000次就是2M；限制大小为2M;
                     	System.err.println("file is over 2M...");
                     	throw new Exception();
                     }
                 }

                 }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
        System.out.println(bytes.length);
        System.out.println(total);
        
        StringTokenizer tokenizer = new StringTokenizer(new String(bytes,encode),"\r\n");
        while (tokenizer.hasMoreElements()){
            String string = (String)tokenizer.nextElement();
            if (rows < 20) {
            	System.out.println(string);
			}
            // 行号+1
            rows++;
            String[] cols = string.split(",");
            
            if (cols == null || cols.length < 5 || rows == 1){
                continue;
            }
            if (cols.length != 12 && rows == 1){
            	System.err.println("cols is not match");
            	break;
            }
            if (rows >2001){
            	System.err.println("rows is over 2000");
            	break;
            }
            
        }
		
		System.out.println(rows);
		
		
	}
}
