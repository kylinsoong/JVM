package com.kylin.jvm.highcpu;

public class HighCPUUsageThread implements Runnable {
	
	private int id;
	
	public HighCPUUsageThread(int id) {
		this.id = id;
	}

	public void run() {

		Thread.currentThread().setName("High-CPU-Usage-" + id);
		
		while(true) {
			long sum = -1;
			for(long i = 0 ; i < Long.MAX_VALUE ; i ++) {
				sum += 1;
			}
			System.out.println("[" + Thread.currentThread().getName() + "] sum = " + sum);
		}
	}

}
