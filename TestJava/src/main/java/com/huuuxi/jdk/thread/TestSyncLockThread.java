package com.huuuxi.jdk.thread;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestSyncLockThread {

	public static void main(String[] args) {
		Socket s;
		try {
			s = new Socket("localhost", 998);
			s.getOutputStream().write("UID".getBytes());
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		for(int i = 0 ;i < 400 ;i++){
//			Thread t = new Thread(new LockThread("--"+i));
//			t.start();
//		}
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
		while (!TestSyncLock.require(key)) {
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
}
