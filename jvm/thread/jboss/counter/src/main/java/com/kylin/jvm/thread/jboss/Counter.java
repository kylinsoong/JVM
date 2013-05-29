package com.kylin.jvm.thread.jboss;

public class Counter {

	private static int count;

	public static synchronized int getCount() {
		try {
			Thread.sleep(10000);
		} catch (Exception ex) {
		}
		return ++count;
	}
}