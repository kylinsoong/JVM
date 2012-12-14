package com.kylin.applepassing.consumer;

import org.apache.log4j.Logger;

import com.kylin.applepassing.MarkedApple;
import com.kylin.applepassing.ThreadBase;
import com.kylin.applepassing.Threshold;


public class AppleConsumer extends ThreadBase implements Runnable {

	private static final Logger logger = Logger.getLogger(AppleConsumer.class);
	
	public AppleConsumer(Threshold threshold, int threadId) {
		super(threshold, threadId);
	}

	public void run() {
		
		Thread.currentThread().setName(getName());

		logger.info("Apple Passing Consumer Start");
		
		while(status()) {
			
			MarkedApple apple = threshold.getMarkedApple(Thread.currentThread().getName());
			sleep(apple.getTime());
			if(logger.isDebugEnabled()) {
				logger.debug("Consume Apple: " + apple);
			}
 		}

		logger.info(getName() + " Stop");
	}

	public String getName() {
		return "applePassing-consumer-" + threadId;
	}

}
