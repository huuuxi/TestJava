package com.huuuxi.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.BasicConfigurator;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.classic.pattern.PropertyConverter;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.spi.PropertyContainer;

public class TestLogback {
	
	private Logger logger = LoggerFactory.getLogger(TestLogback.class);
	
	public void sout(){
		logger.info("www.baidu.com/huuuxi");
	}

	public static void main(String[] args) {
		System.setProperty("logback.xml", "/target/classes/local/logback.xml");
		LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
		JoranConfigurator joranConfigurator = new JoranConfigurator();
		joranConfigurator.setContext(loggerContext);
		try {
			joranConfigurator.doConfigure("target/classes/local/logback.xml");
		} catch (JoranException e) {
			e.printStackTrace();
		}
		TestLogback testLogback = new TestLogback();
		testLogback.sout();
	}
}
