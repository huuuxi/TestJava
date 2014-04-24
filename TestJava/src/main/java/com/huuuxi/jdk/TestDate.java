package com.huuuxi.jdk;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDate {


	public static void main(String[] args) {
		Calendar cla = Calendar.getInstance();
		cla.set(Calendar.HOUR_OF_DAY,0);
		cla.set(Calendar.MINUTE,0);
		cla.set(Calendar.SECOND,0);
		cla.set(Calendar.MILLISECOND,0);
		Date date = cla.getTime();
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:SS").format(date));
		System.out.println(date);
		cla.add(Calendar.DATE, -1);
		date = cla.getTime();
		System.out.println(date);
		cla.add(Calendar.DATE, -1);
		date = cla.getTime();	
		System.out.println(date);	
		cla.add(Calendar.DATE, -1);
		date = cla.getTime();	
		System.out.println(date);	
	}
	
	
}