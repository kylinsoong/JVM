package com.kylin.lab.threaddump.infiniteloop;

public class InfiniteLoopThread implements Runnable {

	private String threadName;
	
	public InfiniteLoopThread(String threadName) {
		super();
		this.threadName = threadName;
	}

	public void run() {
		
		Thread.currentThread().setName(threadName);
		
		for(;;){
			
		}
	}

}
