package com.kylin.test.java7;

public class AssertionTest {

	public static void main(String[] args) {
		assert test() : "Error";
		System.out.println("DONE");
	}

	private static boolean test() {
		return false;
	}

}
