package com.study.Log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Test;

public class TestLog4j1xXmlConfig {
	private static Logger log = Logger.getLogger(TestLog4j1xXmlConfig.class);
	static{
		DOMConfigurator.configure("src/main/resources/log4j.xml");
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
