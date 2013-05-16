package com.kylin.ejb.greeter;

import javax.ejb.Stateful;

import org.apache.log4j.Logger;

import com.kylin.msc.dep.DepUtil;

@Stateful
public class GreeterSession {
	
	private static final Logger logger = Logger.getLogger(GreeterSession.class);

	public GreeterSession() {
		logger.info("GreeterSession Service constructed");
	}
	
	public String sayHello(String name) {
		
		logger.info("Stateful session bean invoked");
		
		return name  + DepUtil.getString();
	}
}
