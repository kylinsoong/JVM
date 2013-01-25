package com.kylin.lab.threaddump.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
	
	private static final int QUEUE_SIZE = 10;
	private static final int POOL_SIZE = 3;

	private ExecutorService threadExecutor;

	private BlockingQueue<String> queue;
	
	private void init() {
		
		queue = new ArrayBlockingQueue<String>(QUEUE_SIZE);
		
		threadExecutor = Executors.newFixedThreadPool(POOL_SIZE);
	}
	
	public void startThread() {
		
		init();
		
		for (int i = 0 ; i < POOL_SIZE ; i ++) {
			String threadName = "pool-sleeping-thread-" + i ;
			SleepingThread thread = new SleepingThread(threadName, queue);
			threadExecutor.execute(thread);
		}
		
		for(int i = 0 ; i < QUEUE_SIZE ; i ++) {
			try {
				queue.put("Test String " + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
