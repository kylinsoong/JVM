package com.kylin.lab.thread.runnable;

public class RunnableThread implements Runnable {
	
	private String threadName;

	public RunnableThread(String threadName) {
		super();
		this.threadName = threadName;
	}

	public void run() {
		
		Thread.currentThread().setName(threadName);
		
		for(;;){
			
		}
	}

}
