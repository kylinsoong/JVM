package com.kylin.applepassing;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.log4j.Logger;


public class Threshold {
	
	private static final Logger logger = Logger.getLogger(Threshold.class);
	
	private static final int QUEUE_SIZE = 1000;

	private Integer capacity;
	
	private BlockingQueue<Apple> appleQueue;
	
	private BlockingQueue<MarkedApple> markedAppleQueue;
	
	public AtomicLong value = new AtomicLong(1);
		
	public Threshold(int capacity) {
		this.capacity = capacity;
		
		validateThresholdCapacity();
		
		initiliseQueue();
	}

	private void initiliseQueue() {
		
		appleQueue = new ArrayBlockingQueue<Apple>(capacity);
		
		if(logger.isDebugEnabled()){
			logger.debug("Created Apple ArrayBlockingQueue with the given capacity: " + capacity);
		}
		
		markedAppleQueue = new ArrayBlockingQueue<MarkedApple>(capacity);
		
		if(logger.isDebugEnabled()){
			logger.debug("Created MarkedApple ArrayBlockingQueue with the given capacity: " + capacity);
		}
		
	}

	private void validateThresholdCapacity() {
		
		if(capacity == 0  || null == capacity) {
			capacity = QUEUE_SIZE ;
		}
		
		logger.info("Set ApplePassing Threshold BlockingQueue Capacity size is: " + capacity);
	}

	public void addToMarkedAppleQueue(String threadName, MarkedApple entity) {
		
		try {
			markedAppleQueue.put(entity);
			
			if(logger.isDebugEnabled()){
				logger.debug(threadName + " add a Entity to markedAppleQueue, Queue size: " + markedAppleQueue.size());
			}
		} catch (InterruptedException e) {
			throw new ApplePassingThresholdException("add Entiry to markedAppleQueue Exception[" + threadName + "]", e );
		}
			
	}
	
	public int markedAppleQueueSize() {
		return markedAppleQueue.size();
	}
	
	public MarkedApple getMarkedApple(String threadName){
		MarkedApple entity;
		try {
			entity = markedAppleQueue.take();
			
			if(logger.isDebugEnabled()) {
				logger.debug(threadName + " Consumed from markedAppleQueue, Queue Size:" + markedAppleQueue.size());
			}
			return entity;
		} catch (InterruptedException e) {
			throw new ApplePassingThresholdException("Take MarkedApple from markedAppleQueue Exception", e);
		}
		
	}	
	
	public void addToAppleQueue(String threadName, Apple entity) {
		
		try {
			appleQueue.put(entity);
			
			if(logger.isDebugEnabled()){
				logger.debug(threadName + " add a Entity to appleQueue, Queue size: " + appleQueue.size());
			}
		} catch (InterruptedException e) {
			throw new ApplePassingThresholdException("add Entiry to appleQueue Exception[" + threadName + "]", e );
		}
			
	}
	
	public int appleQueueSize() {
		return appleQueue.size();
	}
	
	public Apple getApple(String threadName){
		Apple entity;
		try {
			entity = appleQueue.take();
			
			if(logger.isDebugEnabled()) {
				logger.debug(threadName + " Consumed from appleQueue, Queue Size:" + appleQueue.size());
			}
			return entity;
		} catch (InterruptedException e) {
			throw new ApplePassingThresholdException("Take Apple from appleQueue Exception", e);
		}
		
	}	

	
	
}
