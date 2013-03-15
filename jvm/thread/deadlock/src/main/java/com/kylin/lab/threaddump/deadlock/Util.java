package com.kylin.lab.threaddump.deadlock;

public class Util {

	public static void sleep(String threadName, Long milliseconds) {
		
		System.out.println("[" + threadName + "] " + "Sleep " + milliseconds);
		
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void prepare(String threadName, Resource resource) {
		
		System.out.println("\n  " + threadName + " prepare to lock " + resource.getName());
		
		for(int i = 10000 ; i > 0 ; i --) {
			System.out.print("");
		}
		
		System.out.println("\n  " + threadName + " locking " + resource.getName());
	}

	
	
}
