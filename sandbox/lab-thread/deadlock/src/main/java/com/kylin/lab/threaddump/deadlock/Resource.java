package com.kylin.lab.threaddump.deadlock;

public class Resource {

	private final String name;

	public Resource(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public synchronized void lock(String threadName, Resource resource) {
		
		System.out.println("\n  " + threadName  + " locked " + resource.getName());
		
//		Util.sleep(threadName, 1000L);
		
		Util.prepare(threadName, this);
		
		resource.lockInternal(threadName, this);
	}
	
	public synchronized void lockInternal(String threadName, Resource resource) {
		
		System.out.println("\n  " + threadName  + " locked " + resource.getName());
	}
}
