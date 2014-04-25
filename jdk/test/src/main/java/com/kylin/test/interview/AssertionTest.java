package com.kylin.test.interview;

public class AssertionTest {

	public static void main(String[] args) {
		assert test() : "Error";
		System.out.println("DONE");
	}

	private static boolean test() {
		return true;
	}

}
