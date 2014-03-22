package com.huuuxi.log;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.SimpleLayout;

public class TestLog4j {

	private Logger logger = Logger.getLogger(TestLog4j.class);
	private Layout layout = new SimpleLayout();
	private FileAppender fileAppender;
	
	public TestLog4j(Layout layout,Level level,String dir){
		//用默认的Logger配置，不使用properties；
		BasicConfigurator.configure();
		init(layout, level, dir);
	}
	public  void init(Layout layout,Level level,String dir){
		logger.setLevel(level);
		try {
			fileAppender = new FileAppender(layout, dir,false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ConsoleAppender console  = new ConsoleAppender();
		logger.addAppender(console);
		logger.addAppender(fileAppender);
	}
	
	public TestLog4j(){
		System.getProperties();
		PropertyConfigurator.configure("target/classes/local/log4j.properties");
	}
	
	public static void main(String[] args) {
		//TestLog4j test = new TestLog4j(new SimpleLayout(), Level.INFO, "d://abc.txt");
		//test.logger.info("abc");
		TestLog4j test = new TestLog4j();
		test.logger.info("abddd");
		test.logger.warn("------------");
		
	}
	
	
}
