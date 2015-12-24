package com.study.commonlog;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class TestCommonLog {
	private static Log log = LogFactory.getLog(TestCommonLog.class);
	@Test
	public void test(){
		log.trace("trace msg");
		log.debug("debug msg");
		log.info("info msg");
		log.error("error msg");
		log.fatal("fatal msg");
	}
}
