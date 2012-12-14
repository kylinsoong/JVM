package com.kylin.applepassing.marker;

import org.apache.log4j.Logger;

import com.kylin.applepassing.Apple;
import com.kylin.applepassing.MarkedApple;
import com.kylin.applepassing.ThreadBase;
import com.kylin.applepassing.Threshold;

public class AppleMarker extends ThreadBase implements Runnable {

	private static final Logger logger = Logger.getLogger(AppleMarker.class);

	public AppleMarker(Threshold threshold, int threadId) {
		super(threshold, threadId);
	}

	public void run() {

		Thread.currentThread().setName(getName());
		
		logger.info("Apple Passing Marker Start");
		
		while (status()) {
			
			Apple apple = threshold.getApple(Thread.currentThread().getName());
			sleep(apple.getTime());
			MarkedApple markedApple = new MarkedApple(apple.getTime(), apple.getColor(), threshold.value.getAndIncrement());
			if(logger.isDebugEnabled()) {
				logger.debug("Marked Apple: " + markedApple);
			}
			threshold.addToMarkedAppleQueue(Thread.currentThread().getName(), markedApple);
		}

		logger.info(getName() + " Stop");
	}

	public String getName() {
		return "applePassing-marker-" + threadId;
	}

}
