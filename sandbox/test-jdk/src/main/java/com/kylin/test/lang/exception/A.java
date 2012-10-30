package com.kylin.test.lang.exception;

import org.apache.log4j.Logger;

public class A {
	
	private static final Logger logger = Logger.getLogger(A.class);

	public void a1() {
		logger.info("a1()");
		a2();
	}

	protected void a2() {
		logger.info("a2()");
		a3();
	}

	public void a3() {
		logger.info("a3()");
		a4();
	}

	private void a4() {
		logger.info("a4()");
		a5();
	}

	private void a5() {
		logger.info("a5()");
		try {
			new B();
		} catch (Exception e) {
			MyTestRuntimeException ex =  new MyTestRuntimeException("A threw Exception in " + this.getClass(), e);
			logger.error("log error in " + A.class.getSimpleName(), ex);
			throw ex;
		}
	}
}
