package com.kylin.test.lang.exception;

public class Runner {

	public static void main(String[] args){
		
		try {
			new A().a1();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
