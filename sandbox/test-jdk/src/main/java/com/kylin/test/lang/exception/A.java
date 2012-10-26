package com.kylin.test.lang.exception;

public class A {

	public void a1() {
		a2();
	}

	protected void a2() {
		a3();
	}

	public void a3() {
		a4();
	}

	private void a4() {
		a5();
	}

	private void a5() {
		try {
			new B();
		} catch (Exception e) {
			throw new MyTestRuntimeException("A threw Exception", e);
		}
	}
}
