package com.kylin.lab.thread.waitingOnCondition;

public class SleepingThread implements Runnable {

	private String threadName;
	
	public SleepingThread(String threadName) {
		super();
		this.threadName = threadName;
	}

	@SuppressWarnings("static-access")
	public void run() {
		
		Thread.currentThread().setName(threadName);
		
		try {
			Thread.currentThread().sleep(Long.MAX_VALUE);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

}
