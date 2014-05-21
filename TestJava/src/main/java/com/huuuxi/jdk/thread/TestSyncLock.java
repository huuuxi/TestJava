package com.huuuxi.jdk.thread;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

public class TestSyncLock {

	
	public static void main(String[] args) {
		try {
			InetAddress net = InetAddress.getByName("192.168.1.119");
			ServerSocket serverSocket = new ServerSocket(8080,0,net);
			Socket s = serverSocket.accept();
			byte[] b = new byte[1111];
			s.getInputStream().read(b);
			String str = new String(b);
			System.out.println(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static volatile ConcurrentHashMap<String, Long> pool = new ConcurrentHashMap<String, Long>();
	
	public static volatile Integer DATA = 1000;
	
	public  static boolean  require(String key){
		if (key == key.intern()) {
			System.err.println(" error");
		}
		synchronized (key.intern()) {
			if (!pool.containsKey(key)) {
				pool.put(key, System.currentTimeMillis());
				System.out.println("get a key,deal");
				return true;
			}else {
				return false;
			}
		}
	}
}




