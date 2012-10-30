package com.kylin.test.lang.exception;

import org.apache.log4j.Logger;

public class C {
	
	private static final Logger logger = Logger.getLogger(C.class);

	public void c1() throws Exception {
		logger.info("c1()");
		c2();
	}

	private void c2() throws Exception {
		logger.info("c2()");
		c3();
	}

	private void c3() throws Exception {
		logger.info("c3()");
		c4();
	}

	private void c4() throws Exception {
		logger.info("c4()");
		c5();
	}

	private void c5() throws Exception {
		logger.info("c5()");
		MyTestException e = new MyTestException("Exception Test in " + this.getClass(), new Throwable("Exception trace test Root Cause, throw Exception enforcedly."));
		logger.error("log error in " + C.class.getSimpleName(), e);
		throw e;
	}
}
