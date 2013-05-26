package com.kylin.lab.threaddump.condition;

import java.io.IOException;

public class ConditionThread implements Runnable{
	
	private String threadName;
	
	public ConditionThread(String threadName) {
		super();
		this.threadName = threadName;
	}

	public void run() {
		
		Thread.currentThread().setName(threadName);
		
		try {
			System.in.read();
			System.in.skip(System.in.available());
		} catch (IOException e) {
			
		}
		
	}

}
