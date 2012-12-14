package com.kylin.applepassing.threads;

import java.util.Date;

import org.apache.log4j.Logger;

import com.kylin.applepassing.ThreadBase;
import com.kylin.applepassing.Threshold;

public class MonitorThread extends ThreadBase implements Runnable {

	public MonitorThread(Threshold threshold, int threadId) {
		super(threshold, threadId);
	}

	private static final Logger logger = Logger.getLogger(MonitorThread.class);

	public void run() {
		
		Thread.currentThread().setName(getName());
		
		logger.info("Apple Passing MonitorThread Start");
		
		while(status()) {
			
			System.out.println("[" + new Date() + "] appleQueueSize: " + threshold.appleQueueSize() + ", markedAppleQueueSize: " + threshold.markedAppleQueueSize());
		}
		
		logger.info(getName() + " Stop");
	}

	public String getName() {
		return "applePassing-Monitor";
	}

}
