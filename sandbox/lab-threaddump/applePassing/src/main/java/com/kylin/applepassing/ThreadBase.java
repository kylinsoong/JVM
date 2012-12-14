package com.kylin.applepassing;

public abstract class ThreadBase implements IApplePassingThread {

	protected Threshold threshold; 
	
	protected int threadId;
	
	private boolean isRun = true;
	
	public ThreadBase(Threshold threshold, int threadId) {
		this.threshold = threshold;
		this.threadId = threadId;
	}

	public boolean isRun() {
		return isRun;
	}

	public void setRun(boolean isRun) {
		this.isRun = isRun;
	}
	
	public boolean status() {
		return isRun;
	}
	
	public void stop() {
		setRun(false);
	}
	
	protected void sleep(int time) {
		try {
			Thread.currentThread().sleep(time);
		} catch (InterruptedException e) {
			throw new ApplePassingThreadException("Thread sleep exception", e);
		}
	}

}
