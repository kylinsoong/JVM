package com.kylin.lab.thread.waitingForMonitorEntry;

public class LockThread implements Runnable {
	
	private String threadName;
	
	private Resource resource;

	public LockThread(String threadName, Resource resource) {
		super();
		this.threadName = threadName;
		this.resource = resource;
	}

	public void run() {
		
		Thread.currentThread().setName(threadName);
		
		resource.lock(threadName);
	}

}
