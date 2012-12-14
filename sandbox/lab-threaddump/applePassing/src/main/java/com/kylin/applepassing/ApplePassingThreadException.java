package com.kylin.applepassing;

public class ApplePassingThreadException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ApplePassingThreadException(String msg, Exception e) {
		super(msg, e);
	}
}
