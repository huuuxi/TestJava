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

/**
 * @author admin
 *NDC（Nested Diagnostic Context）和MDC（Mapped Diagnostic Context）是log4j种非常有用的两个类，它们用于存储应用程序的上下文信息（context infomation），从而便于在log中使用这些上下文信息。
 *
 *NDC的实现是用hashtable来存储每个线程的stack信息，这个stack是每个线程可以设置当前线程的request的相关信息，然后当前线程在处理过程中只要在log4j配置打印出%x的信息，那么当前线程的整个stack信息就会在log4j打印日志的时候也会都打印出来，这样可以很好的跟踪当前request的用户行为功能。
 *	MDC的实现是使用threadlocal来保存每个线程的Hashtable的类似map的信息，其他功能类似。
 */
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
