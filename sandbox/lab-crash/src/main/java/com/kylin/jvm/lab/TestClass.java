package com.kylin.jvm.lab;

public class TestClass {
	
	static {
		System.loadLibrary("TestJniImpl");
	}

	public TestClass() {
	}

	public static native void printHello();
}
