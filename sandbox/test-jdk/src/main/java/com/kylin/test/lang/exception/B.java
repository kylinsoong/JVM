package com.kylin.test.lang.exception;

public class B {
	
	public B() throws Exception {
		b1();
	}

	public void b1() throws Exception {
		b2();
	}

	private void b2() throws Exception {
		b3();
	}

	private void b3() throws Exception {
		b4();
	}

	private void b4() throws Exception {
		b5();
	}

	private void b5() throws Exception {
		try {
			new C().c1();
		} catch (Exception e) {
			throw new MyTestException("Exception Test in " + this.getClass(), e);
		}
	}

}
