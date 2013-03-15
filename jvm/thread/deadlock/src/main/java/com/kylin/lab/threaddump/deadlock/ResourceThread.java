package com.kylin.lab.threaddump.deadlock;

public class ResourceThread implements Runnable {

	private String threadName;
	
	private Resource resourceA;
	
	private Resource resourceB;
	
	private Boolean tag;
	
	public ResourceThread(String threadName, Resource resourceA, Resource resourceB, Boolean tag) {
		super();
		this.threadName = threadName;
		this.resourceA = resourceA;
		this.resourceB = resourceB;
		this.tag = tag;
	}

	public void run() {
		
		Thread.currentThread().setName(threadName);
		
		if(tag) {
			resourceB.lock(threadName, resourceA);
		} else {
			resourceA.lock(threadName, resourceB);
		}
	}

}
