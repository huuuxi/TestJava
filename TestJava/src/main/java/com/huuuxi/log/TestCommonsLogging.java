package com.huuuxi.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;

/**
 * @author wyliujiangbin
 *	commons-logging 简称 JCL （Jakarta Commons Logging）
 *	日志系统的facade，类似slf4j；
 *	现在基本已经在使用 slf4j
 */
public class TestCommonsLogging {
	
	private static Log logger = LogFactory.getLog(TestCommonsLogging.class);
	
	public void testCommonsLogging(){
		logger.info("hi ,this  is  commons logging");
	}

	/**
	 * @param args
	 * 如果不指定log4j会报错
	 * log4j:WARN No appenders could be found for logger (com.huuuxi.log.TestCommonsLogging).
	 *	log4j:WARN Please initialize the log4j system properly.
	 */
	public static void main(String[] args) {
		TestCommonsLogging test = new TestCommonsLogging();
		// log4j的配置
		PropertyConfigurator.configure("target/classes/local/log4j.properties");
		test.testCommonsLogging();
	}
}
