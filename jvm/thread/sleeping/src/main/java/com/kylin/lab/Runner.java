package com.kylin.lab;

import com.kylin.lab.threaddump.sleeping.SleepingThread;

public class Runner {

	public static void main(String[] args) {
		
		System.out.print("\n  Thread sleeping Lab start...\n");
		
		Thread.currentThread().setName("lab-thread-sleeping-main");
		
		new Thread(new SleepingThread("lab-thread-sleeping")).start();		
		
//		new Thread(new ConditionThread("lab-thread-condition")).start();	
		
		try {
			Thread.sleep(Long.MAX_VALUE);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

}
