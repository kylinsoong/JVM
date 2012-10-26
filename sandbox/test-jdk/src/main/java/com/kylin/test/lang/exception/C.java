package com.kylin.test.lang.exception;

public class C {

	public void c1() throws Exception {
		c2();
	}

	private void c2() throws Exception {
		c3();
	}

	private void c3() throws Exception {
		c4();
	}

	private void c4() throws Exception {
		c5();
	}

	private void c5() throws Exception {
		throw new MyTestException("Exception Test in " + this.getClass(), new Throwable("Root Case"));
	}
}
