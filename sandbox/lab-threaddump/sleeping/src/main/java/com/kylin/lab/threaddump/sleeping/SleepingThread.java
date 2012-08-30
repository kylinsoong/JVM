package com.kylin.lab.threaddump.sleeping;

public class SleepingThread implements Runnable {

	private String threadName;
	
	public SleepingThread(String threadName) {
		super();
		this.threadName = threadName;
	}

	public void run() {
		
		Thread.currentThread().setName(threadName);
		
		try {
			Thread.currentThread().sleep(Long.MAX_VALUE);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
