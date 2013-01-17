package com.kylin.msc.stu.api;

import org.jboss.modules.log.ModuleLogger;
import org.jboss.modules.log.StreamModuleLogger;

public class ModuleLoggerTest {

	public static void main(String[] args) {
		
		String msg = "Error Message";
		Exception e = new Exception("Test Exception");
		
		ModuleLogger logger = new StreamModuleLogger(System.err);
		logger.trace(msg);
		logger.trace(e, msg);
	}

}
