package com.kylin.lab.thread.inObjectWait;

public class NotifyThread implements Runnable {
	
	private String threadName;

	private Resource resource;

	private WaitThread thread;

	public NotifyThread(String threadName, Resource resource, WaitThread thread) {
		super();
		this.threadName = threadName;
		this.resource = resource;
		this.thread = thread;
	}
	
	public void run() {

		Thread.currentThread().setName(threadName);
		
		try {
			thread.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		resource.lock(threadName);
		
		thread.notify();
	}

}
