package com.huuuxi.jdk.thread;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

public class TestSyncLock {

	
	public static void main(String[] args) {
		try {
			InetAddress net = InetAddress.getByName("127.0.0.1");
			ServerSocket serverSocket = new ServerSocket(8080,0,net);
			
			while(1==1){
				Socket s  = serverSocket.accept();
				byte[] b = new byte[3];
				InputStream input = s.getInputStream();
				int length = input.read(b);
				
				String str = new String(b);
				if (str.equals("UID")) {
					s.getOutputStream().write(TestSyncLock.require(str).getBytes());
				}else {
					remove("UID");
				}
				s.close();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static volatile ConcurrentHashMap<String, Long> pool = new ConcurrentHashMap<String, Long>();
	
	public static volatile Integer DATA = 1000;
	
	public  static String  require(String key){
		System.out.println(key);
		if (key == key.intern()) {
			System.err.println(" error");
		}
		synchronized (key.intern()) {
			if (!pool.containsKey(key)) {
				pool.put(key, System.currentTimeMillis());
				System.out.println("get a key,deal");
				return "UID";
			}else {
				return "ABC";
			}
		}
	}
	
	
	public static void remove(String key){
		pool.remove(key);
	}
}





