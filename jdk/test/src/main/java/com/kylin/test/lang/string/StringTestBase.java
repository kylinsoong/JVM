package com.kylin.test.lang.string;

public abstract class StringTestBase {
	
	protected String testStr1 = "01296002|27010102|20120828|121417|1231310|20120828000001357175||06251501010020120828|000000000017000|0|0100000012|2131231123|0002310|";

	protected String testStr2 = "0129";
	
	public abstract void test() throws Exception;
	
	protected void println(Object msg) {
		System.out.println(msg);
	}
}
