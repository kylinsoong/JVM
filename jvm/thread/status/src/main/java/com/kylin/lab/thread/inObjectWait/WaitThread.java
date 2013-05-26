package com.kylin.lab.thread.inObjectWait;

public class WaitThread implements Runnable {

	private String threadName;

	private Resource resource;

	public WaitThread(String threadName, Resource resource) {
		super();
		this.threadName = threadName;
		this.resource = resource;
	}

	public void run() {

		Thread.currentThread().setName(threadName);

		resource.lock(threadName);
		
	}

}
