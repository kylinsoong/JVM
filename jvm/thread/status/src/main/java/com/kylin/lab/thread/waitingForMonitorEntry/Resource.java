package com.kylin.lab.thread.waitingForMonitorEntry;

public class Resource {

	private final String name;

	public Resource(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	@SuppressWarnings("static-access")
	public synchronized void lock(String threadName) {
		
		System.out.println("\n  " + threadName  + " locked " + getName());
				
		try {
			Thread.currentThread().sleep(Long.MAX_VALUE);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	

}
