package com.kylin.lab;

import com.kylin.lab.threaddump.sleeping.SleepingThread;

public class Runner {

	public static void main(String[] args) {
		
		System.out.print("\n  Threaddump sleeping test start...\n");
		
		Thread t1 = new Thread(new SleepingThread("lab-threaddump-thread-sleeping"));
		t1.start();
		
		Thread.currentThread().setName("lab-threaddump-thread-sleeping-main");
		
		try {
			Thread.sleep(Long.MAX_VALUE);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
