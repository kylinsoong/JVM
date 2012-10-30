package com.kylin.test.lang.exception;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class Runner {
	
	private static final Logger logger = Logger.getLogger(Runner.class);
	
	static {
		Logger.getLogger("com.kylin.test.lang.exception").setLevel(Level.INFO);
		String pattern = "%d %-5p [%c] (%t) %m%n";
		PatternLayout layout = new PatternLayout(pattern);
        ConsoleAppender consoleAppender = new ConsoleAppender(layout);
        Logger.getRootLogger().addAppender(consoleAppender); 
	}

	public static void main(String[] args){
		
		logger.info("Start Exception Trace Test Runner");
		
		try {
			new A().a1();
		} catch (Exception e) {
			logger.error("log error in " + Runner.class.getSimpleName(), e);
		}
	}

}
