package com.huuuxi.log;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class TestLogger {

	public static void main(String[] args) {
		logger();
	}
	
	/**
	 * Logger : java 默认的logger，配置在jre的lib包下；
	 * 	默认级别是 INFO；
	 * 三部分组成：优先级，handler，formatter
	 */
	public static void logger(){
		Logger 	logger = Logger.getLogger("testLogger");
		
		// handler
		ConsoleHandler console = new ConsoleHandler();
		logger.addHandler(console);
		FileHandler file;
		try {
			file = new FileHandler("d://logging.txt");
			file.setLevel(Level.INFO);
			//file.setFormatter(new SimpleFormatter());
			file.setFormatter(new MyFormatter());
			logger.addHandler(file);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info("hi , this is logger");
		logger.setLevel(Level.WARNING);
		logger.info("hi ,second logger");
		
	}
}
class MyFormatter extends Formatter{

	@Override
	public String format(LogRecord record) {
		return record.getLevel()+" "+record.getMessage();
	}
	
}
