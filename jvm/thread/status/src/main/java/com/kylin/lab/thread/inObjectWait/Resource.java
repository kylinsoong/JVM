package com.kylin.lab.thread.inObjectWait;

public class Resource {

	private final String name;

	public Resource(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public synchronized void lock(String threadName) {
		
		System.out.println("\n  " + threadName  + " locked " + getName());
				
		for(;;) {}
	}
	

}
