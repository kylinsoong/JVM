package com.kylin.test.util.concurrent;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerSample {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Test Start time:" + new Date() + "\n");
		
		Timer sessionMonitor = new Timer("SessionMonitor", true);
		
		sessionMonitor.schedule(new TimerTask() {

			public void run() {
				System.out.println("\nStart time:" + new Date());
				System.out.println("End time:" + new Date());
			}
		}, 1000 * 15, 1000 * 5);
		
		Thread.currentThread().sleep(Long.MAX_VALUE);
	}

}
