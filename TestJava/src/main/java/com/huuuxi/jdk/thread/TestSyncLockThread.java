package com.huuuxi.jdk.thread;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestSyncLockThread {

	public static void main(String[] args) {
		
		for(int i = 0 ;i < 1 ;i++){
			Thread t = new Thread(new LockThread("--"+i));
			t.start();
		}
	}
}

class LockThread extends Thread{
	
	public LockThread(String name){
		this.name = name;
		key = new String("UID");
		System.out.println(key.hashCode());
	}
	private String key;
	public String name ;
	public void run(){
		System.out.println("Thread :"+ name +" is running");
		while (!("UID"==get())) {
		}
		System.out.println(name+": get DATA:" + TestSyncLock.DATA);
		try {
			sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TestSyncLock.DATA = TestSyncLock.DATA - 10;
		System.out.println(name+": write DATA:" + TestSyncLock.DATA);
		TestSyncLock.pool.remove(key);
		System.out.println(name +": remove the key");
	}
	
	private String get(){
		Socket s = null;
		try {
			s = new Socket("127.0.0.1", 8080);
			s.getOutputStream().write("UID".getBytes());
			byte[] b = new byte[3];
			s.getInputStream().read(b);
			return new String(b);
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			try {
				s.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}
