package com.huuuxi.jdk.concurrent;

import java.util.concurrent.TimeUnit;
/**
 * 
 * @author admin
 *	只是定义了枚举类，实现了TimeUnit
 */
public class TestTimeUnit {

	public static void main(String[] args) {
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
