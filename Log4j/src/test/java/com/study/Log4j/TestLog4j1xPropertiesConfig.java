package com.study.Log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;

public class TestLog4j1xPropertiesConfig {
	private static Logger log = Logger.getLogger(TestLog4j1xPropertiesConfig.class);
	static{
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
	}
	
	@Test
	public void test(){
		log.trace("trace msg");
		log.debug("debug msg");
		log.info("info msg");
		log.error("error msg");
		log.fatal("fatal msg");
	}
}
