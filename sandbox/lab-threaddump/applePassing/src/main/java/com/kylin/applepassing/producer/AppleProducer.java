package com.kylin.applepassing.producer;

import java.util.Random;

import org.apache.log4j.Logger;

import com.kylin.applepassing.Apple;
import com.kylin.applepassing.ThreadBase;
import com.kylin.applepassing.Threshold;

public class AppleProducer extends ThreadBase implements Runnable {

	private static final Logger logger = Logger.getLogger(AppleProducer.class);
	
	private int sleep;
	
	Random r = new Random();
	
	public AppleProducer(Threshold threshold, int threadId, int sleep) {
		super(threshold, threadId);
		this.sleep = sleep;
	}

	public void run() {

		Thread.currentThread().setName(getName());
		
		logger.info("Apple Passing Producer Start");

		while (status()) {
			
			int time = r.nextInt(sleep);
			sleep(time);
			Apple apple = new Apple(time, "Red");
			if(logger.isDebugEnabled()) {
				logger.debug("Produce Apple " + apple);
			}
			threshold.addToAppleQueue(Thread.currentThread().getName(), apple);
		}

		logger.info(getName() + " Stop");
	}

	public String getName() {
		return "applePassing-producer-" + threadId;
	}

	

}
