package com.kylin.test.lang.exception;

import org.apache.log4j.Logger;

public class B {
	
	private static final Logger logger = Logger.getLogger(B.class);
	
	public B() throws Exception {
		logger.info("B()");
		b1();
	}

	public void b1() throws Exception {
		logger.info("b1()");
		b2();
	}

	private void b2() throws Exception {
		logger.info("b2()");
		b3();
	}

	private void b3() throws Exception {
		logger.info("b3()");
		b4();
	}

	private void b4() throws Exception {
		logger.info("b4()");
		b5();
	}

	private void b5() throws Exception {
		logger.info("b5()");
		try {
			new C().c1();
		} catch (Exception e) {
			MyTestException ex =  new MyTestException("Exception Test in " + this.getClass(), e);
			logger.error("log error in " + B.class.getSimpleName(), ex);
			throw ex;
		}
	}

}
