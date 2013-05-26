package com.kylin.lab;

import com.kylin.lab.thread.runnable.RunnableThread;
import com.kylin.lab.thread.waitingForMonitorEntry.LockThread;
import com.kylin.lab.thread.waitingForMonitorEntry.Resource;
import com.kylin.lab.thread.waitingOnCondition.SleepingThread;

public class Runner {

	public static void main(String[] args) {
		
		System.out.print("\n  Thread Status Lab start...\n");
		
		Thread.currentThread().setName("lab-thread-status-main");
		
		// runnable
		new Thread(new RunnableThread("lab-thread-runnable")).start();	
		
		// waiting on condition
		new Thread(new SleepingThread("lab-thread-waitingOnCondition")).start();		
	
		// waiting for monitor entry
		Resource resource = new Resource("Resource A");
		new Thread(new LockThread("lab-thread-waitingForMonitorEntry-1", resource)).start();
		new Thread(new LockThread("lab-thread-waitingForMonitorEntry-2", resource)).start();
	}

}
