package com.huuuxi.log;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author admin
 *slf4j不是具体的日志解决方案，它只服务于各种各样的日志系统。
 *	按照官方的说法，slf4j是一个用于日志系统的简单Facade，允许最终用户在部署其应用时使用其所希望的日志系统。
 *	而在使用slf4j的时候，不需要在代码中或配置文件中指定你打算使用那个具体的日志系统，
 *	slf4j提供了统一的记录日志的接口，只要按照其提供的方法记录即可，最终日志的格式、记录级别、输出方式等通过具体日志系统的配置来实现，因此可以在应用中灵活切换日志系统。 
 *
 *选择JDK自带的日志系统，则只需要将slf4j-api-1.6.1.jar和slf4j-jdk14-1.6.1.jar放置到classpath中即可，
 *如果中途无法忍受JDK自带的日志系统了，想换成log4j的日志系统，
 *仅需要用slf4j-log4j12-1.6.1.jar替换slf4j- jdk14-1.6.1.jar即可（需要log4j的jar及配置文件log4j.properties文件），
 *也可以使用slg4j提供的 simple log，slf4j-simple-1.6.1.jar替换slf4j-jdk14-1.6.1.jar。 
 *
 */
public class TestSlf4j {

	private static final Logger log = LoggerFactory.getLogger(TestSlf4j.class);
	
	public  void testSlf4j(){
		log.info("this is a test");
	}
	
	/*
	 * 未加入任何log日志具体实现系统，会抛出异常；
	 * SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
	SLF4J: Defaulting to no-operation (NOP) logger implementation
	SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
*/	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//log4j 需要指定 配置的位置；
		//logger 不需要因为，jre默认的配置在lib目录下；
		PropertyConfigurator.configure("target/classes/local/log4j.properties");
		TestSlf4j slf4j = new TestSlf4j();
		slf4j.testSlf4j();
	}
	
	
}
