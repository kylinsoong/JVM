package com.kylin.lab.threaddump.threadpool;

import java.util.concurrent.BlockingQueue;

public class SleepingThread implements Runnable {

	private String threadName;
	
	private BlockingQueue<String> queue;
	
	private Boolean isRuning = true;
	
	public Boolean getIsRuning() {
		return isRuning;
	}

	public void setIsRuning(Boolean isRuning) {
		this.isRuning = isRuning;
	}

	public SleepingThread(String threadName, BlockingQueue<String> queue) {
		super();
		this.threadName = threadName;
		this.queue = queue;
	}

	public void run() {
		
		Thread.currentThread().setName(threadName);
		
		while(isRuning) {
			
			try {
				String entity = queue.take();
				System.out.println(threadName + " get [" + entity + "]");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}
