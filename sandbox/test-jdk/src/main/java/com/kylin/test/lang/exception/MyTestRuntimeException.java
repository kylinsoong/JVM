package com.kylin.test.lang.exception;

public class MyTestRuntimeException extends RuntimeException {

	public MyTestRuntimeException(String msg, Exception e) {
		super(msg, e);
	}

	private static final long serialVersionUID = 7041353313581564995L;

}
